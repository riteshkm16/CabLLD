package io.riteshkm16.lld.cab.repository;

import io.riteshkm16.lld.cab.model.User;

import java.util.HashMap;
import java.util.List;

public class UserRepository implements InMemoryRepository<User> {

    private HashMap<Integer,User> userList;
    private Integer autoIncrementId ;

    private Integer incrementId(){
        return ++this.autoIncrementId;
    }


    public UserRepository(HashMap<Integer,User> userList,Integer autoIncrementId){
        this.userList = userList;
        this.autoIncrementId = autoIncrementId;
    }

    @Override
    public User save(User user) {
        user.setId(incrementId());
        this.userList.put(user.getId(),user);
        return user;
    }

    @Override
    public User update(User user) {

        return null;
    }

    @Override
    public User getById(Integer id) {
        return userList.get(id);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

}
