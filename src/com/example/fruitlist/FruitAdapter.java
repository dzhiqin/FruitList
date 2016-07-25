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
		 * ��getView�������ж�convertView���Ϊ�գ���ʹ��LayoutInflaterȥ���ز���
		 * �����Ϊ����ֱ�Ӷ�convertView�������ã������ʹ�������ListView������Ч��
		 */
		if(convertView==null){
			//���convertViewΪnull���ͻ�ȡ������ͼ
			 view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			 viewHolder=new ViewHolder();
			 viewHolder.fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
			 viewHolder.fruitName=(TextView) view.findViewById(R.id.fruit_name);
			 view.setTag(viewHolder);//��viewHolder�洢��view��
		}else{
			//����Ļ�����convertView,ʡȥÿ�μ���view����
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();//���»�ȡviewHolder
		}
		Fruit fruit=getItem(position);		
		
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitName.setText(fruit.getName());
		return view;
	}
	/**
	 * ����һ���ڲ���ViewHolder���ڶԿؼ�ʵ�����л��棬��convertViewΪ�գ�����ViewHolder���󲢽��ؼ���ʵ��������ViewHolder�
	 * Ȼ�����View��setTag��������ViewHolder����洢��View�С���convertView��Ϊ�յ�ʱ�������View��getTag��������
	 * ViewHolder����ȥ�����������пؼ���ʵ������������ViewHolder���û��Ҫÿ�ζ�ͨ��findViewById��������ȡʵ����
	 * @author Administrator
	 *
	 */
	class ViewHolder{
		ImageView fruitImage;
		TextView fruitName;
	}
}
