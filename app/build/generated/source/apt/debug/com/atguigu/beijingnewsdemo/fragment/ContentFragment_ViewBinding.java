// Generated code from Butter Knife. Do not modify!
package com.atguigu.beijingnewsdemo.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.atguigu.beijingnewsdemo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContentFragment_ViewBinding implements Unbinder {
  private ContentFragment target;

  private View view2131558546;

  private View view2131558547;

  private View view2131558548;

  private View view2131558545;

  @UiThread
  public ContentFragment_ViewBinding(final ContentFragment target, View source) {
    this.target = target;

    View view;
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.rb_home, "field 'rbHome' and method 'onViewClicked'");
    target.rbHome = Utils.castView(view, R.id.rb_home, "field 'rbHome'", RadioButton.class);
    view2131558546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_news, "field 'rbNews' and method 'onViewClicked'");
    target.rbNews = Utils.castView(view, R.id.rb_news, "field 'rbNews'", RadioButton.class);
    view2131558547 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_setting, "field 'rbSetting' and method 'onViewClicked'");
    target.rbSetting = Utils.castView(view, R.id.rb_setting, "field 'rbSetting'", RadioButton.class);
    view2131558548 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rg_main, "field 'rgMain' and method 'onViewClicked'");
    target.rgMain = Utils.castView(view, R.id.rg_main, "field 'rgMain'", RadioGroup.class);
    view2131558545 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ContentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vp = null;
    target.rbHome = null;
    target.rbNews = null;
    target.rbSetting = null;
    target.rgMain = null;

    view2131558546.setOnClickListener(null);
    view2131558546 = null;
    view2131558547.setOnClickListener(null);
    view2131558547 = null;
    view2131558548.setOnClickListener(null);
    view2131558548 = null;
    view2131558545.setOnClickListener(null);
    view2131558545 = null;
  }
}
