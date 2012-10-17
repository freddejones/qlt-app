/*
 * Copyright (C) 2011 Dominik Schürmann <dominik@dominikschuermann.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.donations;

public class DonationsConfiguration {

    public static final String TAG = "Donations";

    public static final boolean DEBUG = false;

//    /** Flattr */
//
//    public static final String FLATTR_PROJECT_URL = "http://code.google.com/p/ad-away/";
//    // without http:// !
//    public static final String FLATTR_URL = "flattr.com/thing/369138/AdAway-Ad-blocker-for-Android";
//
//    /** PayPal */
//
//    public static final String PAYPAL_USER = "dominik@dominikschuermann.de";
//    public static final String PAYPAL_ITEM_NAME = "AdAway Donation";
//    public static final String PAYPAL_CURRENCY_CODE = "EUR";

    /** Google Play Store In-App Billing */

    // your public key from the google play publisher account
    public static final String GOOGLE_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAimOBLAt0Gbe2EF5qfJO7qskpCkK1CKsXVCDeSrFpTTwI9ioaldWVf8/7oDkAbwvI7z55ac0GfwjOX4IhpMs1lvRA8rE1KBNyKQLYFTKXqdZrs2GLTtSGVIQlhvvKJz8nPYPp7stbWPJsF3xCjJ52J1iLIsYdj95FD6dTq5S0fBKZPXQBAWzynmH/LQVursWlKmae2SuOKiCfsMnxF5P7QFimueIAFCZipFxEhBAqPwE4JBdUYTqTUaCqXRZVkeneufr/17i9sbYxd8YPHb9onKUfLm/qi7lpSgV9HvHxcVkG5MoN7JtzyuQWxsV3gNp6HjLGbOZtFqkhLnJk/MWjHwIDAQAB";
    // mapping from the possible donations of 1,2,3,5,8 and 15 eur to your in-app items defined in
    // the publisher account of google play
    public static final String[] GOOGLE_CATALOG = new String[] { "qlt.don.10",
            "qlt.don.20", "qlt.don.30", "qlt.don.50", "qlt.don.80",
            "qlt.don.100" };
}
