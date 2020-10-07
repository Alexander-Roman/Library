package com.epam.library.data;

import com.epam.library.dao.ListBookDAO;

public interface ListBookDAOProvider {

    ListBookDAO getListBookDAO();
}
