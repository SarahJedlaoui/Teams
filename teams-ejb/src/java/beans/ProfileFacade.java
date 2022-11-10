/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Profile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author amine
 */
@Stateless
public class ProfileFacade extends AbstractFacade<Profile> {
    @PersistenceContext(unitName = "teams-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfileFacade() {
        super(Profile.class);
    }
            public Profile findbyemail(String email){
        Query q=em.createNamedQuery("Profile.findByEmail").setParameter("email",email);
        try{
            return (Profile)q.getSingleResult();
        }catch(Exception e){
            // no result or mutiple results
            return null;
        }
    }
    public Profile login(String email,String password){
        Profile userProfile=this.findbyemail(email);
        if(userProfile == null)
            return null;
        if(userProfile.getPassword().equals(password))
        return userProfile;
        return null;
    }
}
