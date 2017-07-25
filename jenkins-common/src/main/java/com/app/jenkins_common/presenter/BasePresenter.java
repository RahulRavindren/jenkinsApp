package com.app.jenkins_common.presenter;


import com.app.jenkins_common.view.BaseView;

public abstract class BasePresenter implements PresenterLifeCycle{
  /**
   * @param view - View class attached
   * */
  protected abstract void attachView(BaseView view);
}
