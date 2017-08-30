package com.app.jenkins_common.view;


import com.app.jenkins_common.model.BaseModel;

public interface BaseView<M extends BaseModel> {
  int getViewId();

  void updateView(M model);
}
