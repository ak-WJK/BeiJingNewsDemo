// Generated code from Butter Knife. Do not modify!
package com.atguigu.beijingnewsdemo.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.atguigu.beijingnewsdemo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GuideActivity_ViewBinding implements Unbinder {
  private GuideActivity target;

  private View view2131558526;

  @UiThread
  public GuideActivity_ViewBinding(GuideActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GuideActivity_ViewBinding(final GuideActivity target, View source) {
    this.target = target;

    View view;
    target.viewpager = Utils.findRequiredViewAsType(source, R.id.viewpager, "field 'viewpager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.btn_start_activity, "field 'btnStartActivity' and method 'onViewClicked'");
    target.btnStartActivity = Utils.castView(view, R.id.btn_start_activity, "field 'btnStartActivity'", Button.class);
    view2131558526 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.llPoint = Utils.findRequiredViewAsType(source, R.id.ll_point, "field 'llPoint'", LinearLayout.class);
    target.ivRedPoint = Utils.findRequiredViewAsType(source, R.id.iv_red_point, "field 'ivRedPoint'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GuideActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewpager = null;
    target.btnStartActivity = null;
    target.llPoint = null;
    target.ivRedPoint = null;

    view2131558526.setOnClickListener(null);
    view2131558526 = null;
  }
}
