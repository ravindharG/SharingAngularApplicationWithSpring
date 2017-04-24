package com.vam.rsa.emotor.dao.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.vam.rsa.emotor.dao.JpaDao;
import com.vam.rsa.emotor.entity.Users;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author avinash
 */
public class JpaUserDao extends JpaDao<Users, Long> implements UserDao
{
    public JpaUserDao()
    {
        super(Users.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Users loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Users user = this.findByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("The user with name " + username + " was not found");
        }

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Users findByName(String name)
    {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Users> criteriaQuery = builder.createQuery(this.entityClass);

        Root<Users> root = criteriaQuery.from(this.entityClass);
        Path<String> namePath = root.get("name");
        criteriaQuery.where(builder.equal(namePath, name));
        

        TypedQuery<Users> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        List<Users> users = typedQuery.getResultList();

        if (users.isEmpty()) {
            return null;
        }

        return users.iterator().next();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Users validateUser(String name,String password)
    {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Users> criteriaQuery = builder.createQuery(this.entityClass);

        Root<Users> root = criteriaQuery.from(this.entityClass);
        Path<String> namePath = root.get("name");
        Path<String> passPath = root.get("password");
        criteriaQuery.where(builder.equal(namePath, name),builder.equal(passPath,password));
        TypedQuery<Users> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        List<Users> users = typedQuery.getResultList();

        if (users.isEmpty()) {
            return null;
        }

        return users.iterator().next();
    }
	
}
