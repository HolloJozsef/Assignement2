package ro.utcn.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.utcn.springbootdemo.entities.Restaurant;
import ro.utcn.springbootdemo.entities.Order;
import ro.utcn.springbootdemo.entities.Restaurant;
import ro.utcn.springbootdemo.repository.MenuRepository;
import ro.utcn.springbootdemo.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    List<Restaurant> cacheList=null;
    long time;

    public List<Restaurant> getCacheList() {
        return cacheList;
    }

    public void setCacheList(List<Restaurant> cacheList) {
        this.cacheList = cacheList;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long count) {
        this.time = count;
    }

    public Cache(List<Restaurant> cacheList, int count) {
        this.cacheList = cacheList;
        this.time = count;
    }

    public Cache() {
    }

}
