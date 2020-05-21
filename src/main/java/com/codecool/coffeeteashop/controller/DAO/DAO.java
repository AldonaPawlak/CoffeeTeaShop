package com.codecool.coffeeteashop.controller.DAO;

import java.io.IOException;

public interface DAO {
    public void select();
    public void update() throws IOException;
    public void delete() throws IOException;
    public void insertInto() throws IOException;
}

