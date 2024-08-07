package org.gampiot.robok.feature.template.project.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import org.gampiot.robok.feature.template.R;
import org.gampiot.robok.feature.template.project.model.ProjectTemplate;

public class ProjectTemplateView extends LinearLayout {

    private ShapeableImageView iconView;
    private TextView nameView;

    public ProjectTemplateView(Context context) {
         super(context);
         init(context);
    }

    public ProjectTemplateView(Context context, AttributeSet attrs) {
         super(context, attrs);
         init(context);
    }

    public ProjectTemplateView(Context context, AttributeSet attrs, int defStyleAttr) {
         super(context, attrs, defStyleAttr);
         init(context);
    }

    private void init(Context context) {
         LayoutInflater inflater = LayoutInflater.from(context);
         inflater.inflate(R.layout.layout_template_view, this, true);
         iconView = findViewById(R.id.template_icon);
         nameView = findViewById(R.id.template_name);
    }

    public void setProjectTemplate(ProjectTemplate template) {
         if (template != null) {
             iconView.setImageResource(template.getImageResId());
             nameView.setText(template.getName());
         }
    }
}
