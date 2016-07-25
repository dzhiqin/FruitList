package com.example.fruitlist;

import java.util.List;

import com.example.fruitlist.R.id;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{

	private int resourceId;
	public FruitAdapter(Context context, int resource, List<Fruit> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		View view;
		ViewHolder viewHolder;
		/**
		 * 在getView方法中判断convertView如果为空，则使用LayoutInflater去加载布局
		 * 如果不为空则直接对convertView进行重用，这样就大大提高了ListView的运行效率
		 */
		if(convertView==null){
			//如果convertView为null，就获取布局视图
			 view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			 viewHolder=new ViewHolder();
			 viewHolder.fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
			 viewHolder.fruitName=(TextView) view.findViewById(R.id.fruit_name);
			 view.setTag(viewHolder);//将viewHolder存储在view中
		}else{
			//否则的话就用convertView,省去每次加载view布局
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();//重新获取viewHolder
		}
		Fruit fruit=getItem(position);		
		
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitName.setText(fruit.getName());
		return view;
	}
	/**
	 * 新增一个内部类ViewHolder用于对控件实例进行缓存，当convertView为空，创建ViewHolder对象并将控件的实例都放在ViewHolder里，
	 * 然后调用View的setTag方法，将ViewHolder对象存储在View中。当convertView不为空的时候则调用View的getTag方法，把
	 * ViewHolder重新去除。这样所有控件的实例都缓存在了ViewHolder里，就没必要每次都通过findViewById方法来获取实例了
	 * @author Administrator
	 *
	 */
	class ViewHolder{
		ImageView fruitImage;
		TextView fruitName;
	}
}
