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

  private View view2131427436;

  private View view2131427437;

  private View view2131427438;

  private View view2131427435;

  @UiThread
  public ContentFragment_ViewBinding(final ContentFragment target, View source) {
    this.target = target;

    View view;
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.rb_home, "field 'rbHome' and method 'onViewClicked'");
    target.rbHome = Utils.castView(view, R.id.rb_home, "field 'rbHome'", RadioButton.class);
    view2131427436 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_news, "field 'rbNews' and method 'onViewClicked'");
    target.rbNews = Utils.castView(view, R.id.rb_news, "field 'rbNews'", RadioButton.class);
    view2131427437 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_setting, "field 'rbSetting' and method 'onViewClicked'");
    target.rbSetting = Utils.castView(view, R.id.rb_setting, "field 'rbSetting'", RadioButton.class);
    view2131427438 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rg_main, "field 'rgMain' and method 'onViewClicked'");
    target.rgMain = Utils.castView(view, R.id.rg_main, "field 'rgMain'", RadioGroup.class);
    view2131427435 = view;
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

    view2131427436.setOnClickListener(null);
    view2131427436 = null;
    view2131427437.setOnClickListener(null);
    view2131427437 = null;
    view2131427438.setOnClickListener(null);
    view2131427438 = null;
    view2131427435.setOnClickListener(null);
    view2131427435 = null;
  }
}
