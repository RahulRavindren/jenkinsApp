package com.app.jenkins_common.view;


import com.app.jenkins_common.model.DataModel;

public interface BaseView<M extends DataModel> {
  int getViewId();

  void updateView(M model);
}
