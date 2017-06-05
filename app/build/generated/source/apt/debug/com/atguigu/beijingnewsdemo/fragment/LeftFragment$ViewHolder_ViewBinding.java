// Generated code from Butter Knife. Do not modify!
package com.atguigu.beijingnewsdemo.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.atguigu.beijingnewsdemo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LeftFragment$ViewHolder_ViewBinding implements Unbinder {
  private LeftFragment.ViewHolder target;

  @UiThread
  public LeftFragment$ViewHolder_ViewBinding(LeftFragment.ViewHolder target, View source) {
    this.target = target;

    target.tvMenuGuidle = Utils.findRequiredViewAsType(source, R.id.tv_menu_guidle, "field 'tvMenuGuidle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LeftFragment.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMenuGuidle = null;
  }
}
