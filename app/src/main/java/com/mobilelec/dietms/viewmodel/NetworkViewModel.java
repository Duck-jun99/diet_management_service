package com.mobilelec.dietms.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mobilelec.dietms.adapter.ItemList;
import com.mobilelec.dietms.model.NetworkRepository;

import java.util.List;

public class NetworkViewModel extends ViewModel {
    private final NetworkRepository repository = new NetworkRepository();

    public LiveData<List<ItemList>> getResponseData() {
        return repository.getResponseData();
    }

    public void fetchDataFromApi() {
        repository.fetchDataFromApi();
    }
}
