package com.example.gigigo.demofut52.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.example.gigigo.demofut52.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
public class WidgetDataProvider implements RemoteViewsFactory {

	List<String> mCollections = new ArrayList<>();

	Context mContext = null;

	public WidgetDataProvider(Context context, Intent intent) {
		mContext = context;


	}

	@Override
	public int getCount() {
		return mCollections.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public RemoteViews getLoadingView() {


        return null;
	}

	@Override
	public RemoteViews getViewAt(int position) {
		RemoteViews mView = new RemoteViews(mContext.getPackageName(), R.layout.row_next_match);


		mView.setTextViewText(R.id.row_nom_eL, mCollections.get(position));


		mView.setTextColor(R.id.row_nom_eL, Color.BLACK);

		final Intent fillInIntent = new Intent();

		fillInIntent.setAction(WidgetProvider.ACTION_TOAST);
		final Bundle bundle = new Bundle();
		bundle.putString(WidgetProvider.EXTRA_STRING, mCollections.get(position));
		fillInIntent.putExtras(bundle);







		//mView.setOnClickFillInIntent(R.layout.row_next_match, fillInIntent);


		return mView;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public void onCreate() {
		initData();
	}

	@Override
	public void onDataSetChanged() {
		initData();
	}

	private void initData() {

		mCollections.clear();
		try {
			mCollections=new getData().execute().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onDestroy() {

	}

	private class getData extends AsyncTask<Void,Void,ArrayList<String>>{
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			ArrayList<String>items=new ArrayList<>();

			for(int i=0; i<20; i++){
				Random a=new Random();
				int ip=a.nextInt(200);
				items.add("item"+ip);
			}
			return items;
		}

		@Override
		protected void onPostExecute(ArrayList<String> strings) {
			super.onPostExecute(strings);
		}

	}

}
