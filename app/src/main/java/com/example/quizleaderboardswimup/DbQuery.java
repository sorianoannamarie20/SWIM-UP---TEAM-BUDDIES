package com.example.quizleaderboardswimup;

import android.util.ArrayMap;

import androidx.annotation.NonNull;

import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.example.quizleaderboardswimup.Model.ProfileModel;
import com.example.quizleaderboardswimup.Model.QuestionModel;
import com.example.quizleaderboardswimup.Model.QuizModel;
import com.example.quizleaderboardswimup.Model.RankModel;
import com.example.quizleaderboardswimup.ui.category.CategoryModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.WriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbQuery {
    public static FirebaseFirestore gFirestore;
    public static List<CategoryModel> gcatList = new ArrayList<>();
    public static List<QuizModel> g_quizList =  new ArrayList<>();
    public static int g_selected_cat_index = 0;
    public static int g_selected_quiz_index = 0;

    public static List<QuestionModel> gQuestionList = new ArrayList<>();
    public static List<RankModel> g_userList = new ArrayList<>();
    public static int g_usersCount = 0;
    public static boolean onTopList = false;
    public static ProfileModel userProfile = new ProfileModel("NA", null, null, 0);
    public static RankModel performanceR = new RankModel( "NULL" , 0, -1);

    public static List<String> g_bmIdList = new ArrayList<>();
    public static List<QuestionModel> g_bookmarkList = new ArrayList<>();

    public static final int NOT_VISITED = 0;
    public static final int UNANSWERED = 1;
    public static final int ANSWERED = 2;
    public static final int REVIEW = 3;

    static int tmp;


    public static void createUserData(String email, String name, CompleteListener completeListener) {
        Map<String, Object> userData = new ArrayMap<>();

        userData.put("EMAIL_ID", email);
        userData.put("NAME", name);
        userData.put("TOTAL_SCORE", 0);
        userData.put("BOOKMARKS", 0);

        DocumentReference userDoc = gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        WriteBatch batch = gFirestore.batch();
        batch.set(userDoc, userData);
        DocumentReference countDoc = gFirestore.collection("USERS").document("TOTAL_USERS");
        batch.update(countDoc, "COUNT", FieldValue.increment(1));

        batch.commit()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        completeListener.onSuccess();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();


                    }
                });


    }
    public static void saveProfileData(final String name, String phone, CompleteListener completeListener){

        Map<String, Object> profileData = new ArrayMap<>();
        profileData.put("NAME", name);

        if (phone != null)
            profileData.put("PHONE", phone);

        gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getUid())
                .update(profileData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        userProfile.setName(name);

                        if (phone != null)
                            userProfile.setPhone(phone);

                        completeListener.onSuccess();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        completeListener.onFailure();

                    }
                });
    }

    public static void getUserData(final CompleteListener completeListener)
    {
        gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        userProfile.setName(documentSnapshot.getString("NAME"));
                        userProfile.setEmil(documentSnapshot.getString("EMAIL_ID"));

                        if (documentSnapshot.getString("PHONE") != null)
                            userProfile.setPhone(documentSnapshot.getString("PHONE"));

                        if (documentSnapshot.get("BOOKMARKS") != null)
                            userProfile.setBookMarksCount(documentSnapshot.getLong("BOOKMARKS").intValue());

                        performanceR.setScore(documentSnapshot.getLong("TOTAL_SCORE").intValue());
                        userProfile.setName(documentSnapshot.getString("NAME"));
                        completeListener.onSuccess();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();


                    }
                });
    }
    public static void loadScore(CompleteListener completeListener){

        gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getUid())
                .collection("USER_DATA").document("MY_SCORES")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        for (int i=0; i < g_quizList.size(); i++)
                        {
                            int top = 0;
                            if (documentSnapshot.get(g_quizList.get(i).getQuizID()) != null )
                            {
                                top = documentSnapshot.getLong(g_quizList.get(i).getQuizID()).intValue();
                            }

                            g_quizList.get(i).setTopscore(top);
                        }

                        completeListener.onSuccess();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        completeListener.onFailure();

                    }
                });


    }

    public static void loadBmIds(final CompleteListener completeListener){
        g_bmIdList.clear();
        gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getUid())
                .collection("USER_DATA").document("BOOKMARKS")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        int count = userProfile.getBookMarksCount();
                        for (int i=0; i < count; i++ )
                        {
                            String bmID = documentSnapshot.getString("BM" + String.valueOf(i+1) + "_ID");
                            g_bmIdList.add(bmID);
                        }

                        completeListener.onSuccess();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();
                    }
                });


    }

    public static void loadBookmarks(final CompleteListener completeListener){
        g_bookmarkList.clear();
        tmp = 0;
        if (g_bmIdList.size() == 0)
            completeListener.onSuccess();


        for (int i = 0; i<g_bmIdList.size(); i++){
            String docID = g_bmIdList.get(i);

            gFirestore.collection("Questions").document(docID)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists())
                            {
                                g_bookmarkList.add(new QuestionModel(
                                        documentSnapshot.getId(),
                                        documentSnapshot.getString("QUESTION"),
                                        documentSnapshot.getString("A"),
                                        documentSnapshot.getString("B"),
                                        documentSnapshot.getString("C"),
                                        documentSnapshot.getString("D"),
                                        documentSnapshot.getLong("ANSWER").intValue(),
                                        0, -1, false
                                ));
                            }
                            tmp++;
                            if (tmp == g_bmIdList.size())
                            {
                                completeListener.onSuccess();
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            completeListener.onFailure();
                        }
                    });


        }



    }
    public static void getTopUsers(CompleteListener completeListener){
        g_userList.clear();
        String myUID = FirebaseAuth.getInstance().getUid();
        gFirestore.collection("USERS")
                .whereGreaterThan("TOTAL_SCORE", 0)
                .orderBy("TOTAL_SCORE", Query.Direction.DESCENDING)
                .limit(20)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        int rank = 1;

                        for (QueryDocumentSnapshot doc : queryDocumentSnapshots)
                        {
                            g_userList.add(new RankModel(
                                    doc.getString("NAME"),
                                    doc.getLong("TOTAL_SCORE").intValue(),
                                    rank


                            ));

                            if (myUID.compareTo(doc.getId()) == 0 )
                            {
                                onTopList = true;
                                performanceR.setRank(rank);
                            }

                            rank++;


                        }
                        completeListener.onSuccess();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();



                    }
                });
    }

    public static void getUsersCount(CompleteListener completeListener)
    {
        gFirestore.collection("USERS").document("TOTAL_USERS")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        g_usersCount = documentSnapshot.getLong("COUNT").intValue();
                        completeListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();


                    }
                });
    }



    public static void saveResult( final int score, final CompleteListener completeListener)
    {
        WriteBatch batch = gFirestore.batch();

        //Bookmarks

        Map<String, Object> bmData = new ArrayMap<>();
        for (int i=0; 1< g_bmIdList.size(); i++)
        {
            bmData.put("BM" + String.valueOf(i+1) + "_ID", g_bmIdList.get(i));
        }

        DocumentReference bmDoc = gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getUid())
                .collection("USER_DATA").document("BOOKMARKS");

        batch.set(bmDoc, bmData);


        DocumentReference userDoc  = gFirestore.collection("USERS").document(FirebaseAuth.getInstance().getUid());

        Map<String, Object> userData = new ArrayMap<>();
        userData.put("TOTAL_SCORE", score);
        userData.put("BOOKMARKS", g_bmIdList.size());

        batch.update(userDoc, userData);



        if (score > g_quizList.get(g_selected_quiz_index).getTopscore())
        {
            DocumentReference scoreDoc = userDoc.collection("USER_DATA").document("MY_SCORES");

            Map<String, Object> quizData =  new ArrayMap<>();
            quizData.put(g_quizList.get(g_selected_quiz_index).getQuizID(), score);

            batch.set(scoreDoc, quizData, SetOptions.merge());

        }
        batch.commit()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        if (score > g_quizList.get(g_selected_quiz_index).getTopscore())
                            g_quizList.get(g_selected_quiz_index).setTopscore(score);

                        performanceR.setScore(score);

                        completeListener.onSuccess();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        completeListener.onFailure();


                    }
                });

    }

    public static void loadCategories(final CompleteListener completeListener) {
        gcatList.clear();
        gFirestore.collection("QUIZ").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        Map<String, QueryDocumentSnapshot> docList = new ArrayMap<>();

                        for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                            docList.put(doc.getId(), doc);
                        }
                        QueryDocumentSnapshot catListDoc = docList.get("Categories");

                        long catCount = catListDoc.getLong("COUNT");

                        for (int i = 1; i <= catCount; i++) {
                            String catID = catListDoc.getString("CAT" + String.valueOf(i) + "_ID");
                            QueryDocumentSnapshot catDoc = docList.get(catID);
                            int noOfQuiz = catDoc.getLong("NO_OF_QUIZ").intValue();
                            String catName = catDoc.getString("NAME");
                            gcatList.add(new CategoryModel(catID, catName, noOfQuiz));
                        }


                        completeListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();


                    }
                });


    }


    public static void loadQuestions(final CompleteListener completeListener)
    {
        gQuestionList.clear();
        gFirestore.collection("Questions")
                .whereEqualTo("CATEGORY", gcatList.get(g_selected_cat_index).getDocID())
                .whereEqualTo("QUIZ", g_quizList.get(g_selected_quiz_index).getQuizID())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        for (DocumentSnapshot doc : queryDocumentSnapshots)
                        {
                            boolean bookmarkDone = false;

                            if (g_bmIdList.contains(doc.getId()))
                                bookmarkDone = true;

                            gQuestionList.add(new QuestionModel(
                                    doc.getId(),
                                    doc.getString("QUESTION"),
                                    doc.getString("A"),
                                    doc.getString("B"),
                                    doc.getString("C"),
                                    doc.getString("D"),
                                    doc.getLong("ANSWER").intValue(),
                                    -1,
                                    NOT_VISITED, bookmarkDone
                            ));

                        }
                        completeListener.onSuccess();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();


                    }
                });




    }


    public static void loadQuizData(final CompleteListener completeListener)
    {
        g_quizList.clear();
        gFirestore.collection("QUIZ").document(gcatList.get(g_selected_cat_index).getDocID())
                .collection("QUIZ_LIST").document("QUIZ_INFO")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        int noOfQuiz = gcatList.get(g_selected_cat_index).getNoOfQuiz();

                        for (int i=1; i <= noOfQuiz; i++){
                            g_quizList.add(new QuizModel(documentSnapshot.getString("QUIZ" + String.valueOf(i) + "_ID"),
                                    0,
                                    documentSnapshot.getLong("QUIZ" + String.valueOf(i) + "_TIME").intValue()
                            ));
                        }



                        completeListener.onSuccess();



                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        completeListener.onFailure();

                    }
                });

    }

    public  static void loadData(final CompleteListener completeListener)
    {
        loadCategories(new CompleteListener() {
            @Override
            public void onSuccess() {

                getUserData(new CompleteListener() {
                    @Override
                    public void onSuccess() {
                        getUsersCount(new CompleteListener() {
                            @Override
                            public void onSuccess() {
                                loadBmIds(completeListener);

                            }

                            @Override
                            public void onFailure() {
                                completeListener.onFailure();
                            }
                        });

                    }

                    @Override
                    public void onFailure() {
                        completeListener.onFailure();

                    }
                });

            }

            @Override
            public void onFailure() {

                completeListener.onFailure();




            }
        });
    }

}
