package dev.manhnx.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.mysql.cj.jdbc.CallableStatement;

import dev.manhnx.dal.CafeDAL;
import dev.manhnx.dal.OrderDAL;
import dev.manhnx.persistance.Cafe;
import dev.manhnx.ui.AccountUI;

public class CafeBL {
    private static CafeDAL cafeDAL = new CafeDAL();

    // private static String productname;
    // static CallableStatement callableStatement = null;
    // static AccountUI accountUI;
    public List<Cafe> getALLCafe() {
        return cafeDAL.getALL();
    }

    public boolean addCafe(Cafe cafe) {
        return cafeDAL.insertCafe(cafe);
    }

    public boolean updateCafe(Cafe cafe) {
        return cafeDAL.updateCafe(cafe);
    }

    public List<Cafe> getbyId(int id) {
        return cafeDAL.getId(id);
    }

    public List<Cafe> getbyName(String name) {
        return cafeDAL.getName(name);
    }

}