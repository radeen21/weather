package com.example.data.network;

import android.content.Context;

import com.example.data.R;

import java.security.cert.CertPathValidatorException;

/**
 * Created by mexanjuadha on 3/15/17.
 */

public class NetworkCertificateException extends CertPathValidatorException implements Localizable {

    private Context context;

    public NetworkCertificateException(Context context) {
        this.context = context;
    }

    @Override
    public String getErrorEnglish() {
        return context.getString(R.string.warn_secure_connection_en);
    }

    @Override
    public String getErrorBahasa() {
        return context.getString(R.string.warn_secure_connection_id);
    }
}