package com.mobilelec.dietms.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mobilelec.dietms.db.UserEntity;
import com.mobilelec.dietms.model.DBRepository;

import java.util.List;

public class DBViewModel extends AndroidViewModel {

    DBRepository userRepository;
    LiveData<List<UserEntity>> getAll;

    public DBViewModel(Application application) {
        super(application);
        userRepository = new DBRepository(application);
        getAll = userRepository.getAll();
    }

    public void insert(UserEntity user) {
        userRepository.insert(user);
    }

    public LiveData<List<UserEntity>> getAll() {
        return getAll;
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}