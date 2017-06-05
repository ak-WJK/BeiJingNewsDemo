// Generated code from Butter Knife. Do not modify!
package com.atguigu.beijingnewsdemo.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.atguigu.beijingnewsdemo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WecomeActivity_ViewBinding implements Unbinder {
  private WecomeActivity target;

  @UiThread
  public WecomeActivity_ViewBinding(WecomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WecomeActivity_ViewBinding(WecomeActivity target, View source) {
    this.target = target;

    target.rootMain = Utils.findRequiredViewAsType(source, R.id.root_main, "field 'rootMain'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WecomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rootMain = null;
  }
}
