package com.apporio.demotaxiappdriver;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apporio.demotaxiappdriver.currentwork.API_S;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.logger.Logger;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.models.ModelUploadVehoicleDocument;
import com.apporio.demotaxiappdriver.models.ModelUploadpersonalDocument;
import com.apporio.demotaxiappdriver.others.ImageCompressMode;
import com.apporio.demotaxiappdriver.samwork.ApiManager;
import com.sampermissionutils.AfterPermissionGranted;
import com.sampermissionutils.EasyPermissions;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import customviews.typefacesviews.TypeFaceGoogle;
import customviews.typefacesviews.TypeFaceGoogleBold;

public class PhotoUploaderActivity extends Activity implements EasyPermissions.PermissionCallbacks, DatePickerDialog.OnDateSetListener, ApiManager.APIFETCHER {

    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.camera)
    TypeFaceGoogleBold camera;
    @Bind(R.id.gallery)
    TypeFaceGoogleBold gallery;
    @Bind(R.id.date)
    TypeFaceGoogle date;
    @Bind(R.id.submit)
    CardView submit;
    @Bind(R.id.llExpiryLayout)
    LinearLayout llExpiryLayout;
    private Uri imageUri;
    ApiManager apiManager;
    ProgressDialog progressDialog;
    private File compressedImage;
    private ContentValues values;
    private Bitmap thumbnail;
    private SessionManager sessionManager;
    private static final int RC_CAMERA_PERM = 123;
    private static final int PICK_IMAGE = 124;
    private static final int CAMERS_PICKER = 122;
    private static final String TAG = "";
    Uri selectedImage;
    String imagePath = "", COMPRESSES_IMAGE_VEHICLE = "";
    Bitmap bitmap1;
    String EXPIRY_DATE = "";
    String strType="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_photo_uploader);
        ButterKnife.bind(this);

        apiManager = new ApiManager(this, this);
        sessionManager = new SessionManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(this.getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);

        EXPIRY_DATE = getIntent().getStringExtra(IntentKeys.EXPIRY_DATE);

        llExpiryLayout.setVisibility((null == EXPIRY_DATE || EXPIRY_DATE.isEmpty() || EXPIRY_DATE.equals("2")) ? View.GONE : View.VISIBLE);

        try {
            strType = getIntent().getStringExtra("TYPE");
        } catch (Exception e) {

        }
        camera.setOnClickListener(view -> {
            try {
                cameraTask();
            } catch (Exception e) {
            }
        });

        gallery.setOnClickListener(view -> {
            try {
                selectFromgalery();
            } catch (Exception e) {
            }
        });

        date.setOnClickListener(view -> {
            try {
                openDateFDialog();
            } catch (Exception e) {
                Log.d("" + TAG, "Exception caught while date click --> " + e.getMessage());
            }
        });

        submit.setOnClickListener(view -> {
            try {
                if (null != EXPIRY_DATE && EXPIRY_DATE.equals("1") && !EXPIRY_DATE.isEmpty()) {
                    if (date.getText().toString().equals("DD MM YYYY")) {

                        Toast.makeText(PhotoUploaderActivity.this, R.string.please_expiry_date, Toast.LENGTH_SHORT).show();
                    } else {
                        if (getIntent().getExtras().getString(IntentKeys.DOCUMENT_TYPE).equals("1")) {  // that is personal documents
                            HashMap<String, String> data = new HashMap<>();
                            HashMap<String, File> images_data = new HashMap<>();
                            data.put("driver", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_ID));
                            data.put("document", "" + getIntent().getExtras().getString("" + IntentKeys.DOCUMENT_ID));
                            data.put("expire_date", "" + date.getText().toString());
                            data.put("type", ""+strType);
                            /*if(EXPIRY_DATE.equals("1")){

                            }else {
                                data.put("expire_date", "");
                            }*/
                            images_data.put("document_image", new File(COMPRESSES_IMAGE_VEHICLE));
                            apiManager._post_image_with_secreteonly(API_S.Tags.UPLOAD_DRIVER_DOCUMENT, API_S.Endpoints.UPLOAD_DRIVER_DOCUMENT, data, images_data);
                        } else if (getIntent().getExtras().getString(IntentKeys.DOCUMENT_TYPE).equals("2")) { // // vehicle documents
                            HashMap<String, String> data = new HashMap<>();
                            HashMap<String, File> images_data = new HashMap<>();
                            data.put("driver", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_ID));
                            data.put("document", "" + getIntent().getExtras().getString("" + IntentKeys.DOCUMENT_ID));
                            data.put("expire_date", "" + date.getText().toString());
                            data.put("type", ""+strType);

                            /*if(EXPIRY_DATE.equals("1")){
                                data.put("expire_date", "" + date.getText().toString());
                            }else {
                                data.put("expire_date", "");
                            }*/
                            data.put("driver_vehicle_id", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_VEHICLE_ID));
                            images_data.put("document_image", new File(COMPRESSES_IMAGE_VEHICLE));
                            apiManager._post_image_with_secreteonly(API_S.Tags.UPLOAD_VEHICLE_DOCUMENT, API_S.Endpoints.UPLOAD_VEHICLE_DOCUMENT, data, images_data);
                        }

                    }
                } else {
                    if (getIntent().getExtras().getString(IntentKeys.DOCUMENT_TYPE).equals("1")) {  // that is personal documents
                        HashMap<String, String> data = new HashMap<>();
                        HashMap<String, File> images_data = new HashMap<>();
                        data.put("driver", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_ID));
                        data.put("document", "" + getIntent().getExtras().getString("" + IntentKeys.DOCUMENT_ID));
                        data.put("type", ""+strType);
                        /*if(EXPIRY_DATE.equals("1")){
                            data.put("expire_date", "" + date.getText().toString());
                        } else {
                            data.put("expire_date", "");
                        }*/
                        images_data.put("document_image", new File(COMPRESSES_IMAGE_VEHICLE));
                        apiManager._post_image_with_secreteonly(API_S.Tags.UPLOAD_DRIVER_DOCUMENT, API_S.Endpoints.UPLOAD_DRIVER_DOCUMENT, data, images_data);
                    } else if (getIntent().getExtras().getString(IntentKeys.DOCUMENT_TYPE).equals("2")) { // // vehicle documents
                        HashMap<String, String> data = new HashMap<>();
                        HashMap<String, File> images_data = new HashMap<>();
                        data.put("driver", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_ID));
                        data.put("document", getIntent().getExtras().getString("" + IntentKeys.DOCUMENT_ID));
                        data.put("type", ""+strType);
                        /*if(EXPIRY_DATE.equals("1")){
                            data.put("expire_date", "" + date.getText().toString());
                        }else {
                            data.put("expire_date", "");
                        }*/
                        data.put("driver_vehicle_id", "" + getIntent().getExtras().getString("" + IntentKeys.DRIVER_VEHICLE_ID));
                        images_data.put("document_image", new File(COMPRESSES_IMAGE_VEHICLE));
                        apiManager._post_image_with_secreteonly(API_S.Tags.UPLOAD_VEHICLE_DOCUMENT, API_S.Endpoints.UPLOAD_VEHICLE_DOCUMENT, data, images_data);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() throws Exception {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            try { // Have permission, do the thing!
                values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "New Picture");
                values.put(MediaStore.Images.Media.DESCRIPTION, "From your Camera");
                imageUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, CAMERS_PICKER);
            } catch (Exception e) {
            }
        } else {
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera), RC_CAMERA_PERM, Manifest.permission.CAMERA);
        }
    }

    public void selectFromgalery() throws Exception {
        Intent i1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i1.setType("image/*");
        startActivityForResult(i1, PICK_IMAGE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d("" + TAG, "Permission Granted");
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d("" + TAG, "Permission Denied");

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case CAMERS_PICKER:
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        if (resultCode == RESULT_OK) {
                            ImageCompressMode imageCompressModeee = new ImageCompressMode(this);
//
//                            Bitmap photo = (Bitmap) data.getExtras().get("data");
//                            image.setImageBitmap(photo);
//                            Uri tempUri = getImageUri(getApplicationContext(), photo);
//                            imagePath = getPath(tempUri);
                            thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                            image.setImageBitmap(thumbnail);
                            imagePath = getRealPathFromURI(imageUri);


                            ExifInterface ei = new ExifInterface(imagePath);
                            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                                    ExifInterface.ORIENTATION_UNDEFINED);

                            Bitmap rotatedBitmap = null;
                            switch (orientation) {

                                case ExifInterface.ORIENTATION_ROTATE_90:
                                    rotatedBitmap = rotateImage(thumbnail, 90);
                                    break;

                                case ExifInterface.ORIENTATION_ROTATE_180:
                                    rotatedBitmap = rotateImage(thumbnail, 180);
                                    break;

                                case ExifInterface.ORIENTATION_ROTATE_270:
                                    rotatedBitmap = rotateImage(thumbnail, 270);
                                    break;

                                case ExifInterface.ORIENTATION_NORMAL:
                                default:
                                    rotatedBitmap = thumbnail;
                            }
                            image.setImageBitmap(rotatedBitmap);

                            ImageCompressMode imageCompressModee = new ImageCompressMode(this);
                            COMPRESSES_IMAGE_VEHICLE = imageCompressModee.compressImage(imagePath);


                            // COMPRESSES_IMAGE_VEHICLE = imageCompressModeee.compressImage(getRealPathFromURI(imageUri));


                            if (EXPIRY_DATE.equals("1")) {
                                Toast.makeText(PhotoUploaderActivity.this, R.string.attach_expirey_date_of_your_document, Toast.LENGTH_SHORT).show();
                                openDateFDialog();
                            }

                        }
                    } catch (Exception e) {
                        Logger.e("Exception -->" + e.toString());
                    }
                }
                break;


            case PICK_IMAGE:
                try {
                    ImageCompressMode imageCompressMode = new ImageCompressMode(this);
                    selectedImage = data.getData();
                    imagePath = getPath(selectedImage);
                    COMPRESSES_IMAGE_VEHICLE = imageCompressMode.compressImage(getRealPathFromURI(data.getData()));
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();

                    // Set the Image in ImageView after decoding the String
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(filePath, options);
                    final int REQUIRED_SIZE = 300;
                    int scale = 1;
                    while (options.outWidth / scale / 2 >= REQUIRED_SIZE && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                        scale *= 2;
                    options.inSampleSize = scale;
                    options.inJustDecodeBounds = false;
                    bitmap1 = BitmapFactory.decodeFile(filePath, options);
                    image.setImageBitmap(bitmap1);
                    if (EXPIRY_DATE.equals("1")) {
                        Toast.makeText(PhotoUploaderActivity.this, R.string.attach_expirey_date_of_your_document, Toast.LENGTH_SHORT).show();
                        openDateFDialog();
                    }
                } catch (Exception e) {
//                    Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }


    private void openDateFDialog() throws Exception {


        Calendar calendar = Calendar.getInstance();

        DatePickerDialog dpd = DatePickerDialog.newInstance(PhotoUploaderActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dpd.setMinDate(calendar);
        dpd.setCancelText("" + getResources().getString(R.string.cancel));
        dpd.setOkText("" + getResources().getString(R.string.ok));
        dpd.setAccentColor(PhotoUploaderActivity.this.getResources().getColor(R.color.colorPrimary));
        dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
            }
        });
        dpd.show(getFragmentManager(), "Date Picker Dialog");
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(year, monthOfYear, dayOfMonth);

        String data = dateFormat.format(cal.getTime());

        //  String data = "" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
        date.setText("" + data);
    }


    @Override
    public void onAPIRunningState(int a, String APINAME) {
        try {
            if (a == ApiManager.APIFETCHER.KEY_API_IS_STARTED) {
                progressDialog.show();
            } else if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onFetchComplete(Object script, String APINAME) {

        try {
            switch (APINAME) {
                case API_S.Tags.UPLOAD_DRIVER_DOCUMENT:
                    ModelUploadpersonalDocument modelUploadpersonalDocument = SingletonGson.getInstance().fromJson("" + script, ModelUploadpersonalDocument.class);
                    Toast.makeText(this, "" + modelUploadpersonalDocument.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case API_S.Tags.UPLOAD_VEHICLE_DOCUMENT:
                    ModelUploadVehoicleDocument modelUploadVehoicleDocument = SingletonGson.getInstance().fromJson("" + script, ModelUploadVehoicleDocument.class);
                    Toast.makeText(this, "" + modelUploadVehoicleDocument.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
            }
        } catch (Exception e) {
            Log.d("" + TAG, "Exception caught onfetchcomplete " + e.getMessage());
        }
    }

    @Override
    public void onFetchResultZero(String script, String APINAME) {
        Toast.makeText(this, "" + script, Toast.LENGTH_SHORT).show();
    }


}
