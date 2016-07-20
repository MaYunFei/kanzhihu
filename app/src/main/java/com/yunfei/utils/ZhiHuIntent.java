package com.yunfei.utils;

import android.content.Context;
import android.content.Intent;

import java.net.URISyntaxException;

/**
 * Created by yunfei on 16/7/12.
 */
public class ZhiHuIntent {

    public static Intent getQuestionIntent(Object questionId) {

        String action = String.format("intent://questions/%s/#Intent;scheme=zhihu;package=com.zhihu.android;end", questionId);
        Intent intent = null;
        try {
            intent = Intent.parseUri(action, Intent.URI_ANDROID_APP_SCHEME);
        } catch (URISyntaxException e) {
//            e.printStackTrace();
        }

        return intent;
    }

    public static void starZhiHuQuestionActivity(Context context, Object questionId) {

        Intent questionIntent = getQuestionIntent(questionId);
        if (questionIntent != null)
            context.startActivity(questionIntent);
    }

    public static Intent getQuestionAnswerIntent(Object questionId, Object answerId) {

        String action = String.format("intent://questions/%s/answers/%s/#Intent;scheme=zhihu;package=com.zhihu.android;end", questionId, answerId);
        Intent intent = null;
        try {
            intent = Intent.parseUri(action, Intent.URI_ANDROID_APP_SCHEME);
        } catch (URISyntaxException e) {
//            e.printStackTrace();
        }

        return intent;
    }

    public static void starZhiHuAnswernActivity(Context context, Object questionId, Object answerId) {

        Intent questionAnswerIntent = getQuestionAnswerIntent(questionId, answerId);
        if (questionAnswerIntent != null)
            context.startActivity(questionAnswerIntent);
    }

    public static Intent getPeopleIntent(Object authorhash) {

        String action = String.format("intent://people/%s/#Intent;scheme=zhihu;package=com.zhihu.android;end", authorhash);
        Intent intent = null;
        try {
            intent = Intent.parseUri(action, Intent.URI_ANDROID_APP_SCHEME);
        } catch (URISyntaxException e) {
//            e.printStackTrace();
        }

        return intent;
    }


    public static void starZhiHuPeopleActivity(Context context, Object authorhash) {

        Intent peopleIntent = getPeopleIntent(authorhash);
        if (peopleIntent != null)
            context.startActivity(peopleIntent);
    }


}
