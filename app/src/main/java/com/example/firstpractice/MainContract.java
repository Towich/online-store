package com.example.firstpractice;

import java.util.List;

public interface MainContract {

    // UI Layer
    interface View {
        List<String> showItems(int quantity);
    }

    // Domain Layer
    interface Delegate {
        List<String> onViewCreatedForDelegate(int quantity);
    }

    // Data Layer
    interface Repository {
        List<String> CreateListOfItems(int quantity);
    }
}
