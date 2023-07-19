package com.example.collegeinfo.data

import android.util.Log
import com.example.collegeinfo.model.College
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CollegeData{
    fun setCollegeData(){
        var college: College? = College(
            "Delhi Technological University (DTU)",
            1941,
            "DTU",
            "gs://cloud-firestore-6a33c.appspot.com/logo_DTU.png",
            "gs://cloud-firestore-6a33c.appspot.com/photo_DTU.webp",
            "Formerly known as Delhi College of Engineering, Delhi Technological University (DTU) was established in 1941. The university is accredited by the NAAC with an 'A' grade and is also approved by the University Grant Commission (UGC). DTU ranked 35 for ‘Engineering’, 38 for ‘University’ and 63 for ‘Overall’ category by the NIRF Rankings 2022. DTU is counted amongst the oldest Engineering colleges in India. DTU currently offers more than 80 courses via its 17 departments. Out of these departments, the University School of Management and Entrepreneurship (USME) was established recently and is also known as the DTU East Delhi Campus. Additionally, DTU formed the Delhi School of Management (DSM) as a department under it to offer courses in the field of Management. All the UG, PG and doctoral programmes available in the field of Engineering, Design, Science and Management, among others, are offered together via DTU’s main campus, DSM and the University School of Management & Entrepreneurship (USME).",
            "Rohini, Delhi"
        )
        addCollege(college!!)
        college = College(
            "Netaji Subhas University of Technology (NSUT)",
            1983,
            "NSUT",
            "gs://cloud-firestore-6a33c.appspot.com/logo_NSUT.png",
            "gs://cloud-firestore-6a33c.appspot.com/photo_NSUT.JPG",
            "Netaji Subhas University of Technology (NSUT), formerly known as Netaji Subhas Institute of Technology (NSIT) is a state-level university. NSIT was established in 1983 and in 2018 the institute was given university status, hence making it a non-affiliating university. Earlier it was affiliated with the University of Delhi. NSUT is ranked 88 for BTech by NIRF 2021. NSIT Delhi is accredited by NAAC and is approved by AICTE and UGC. NSIT consists of 13 departments offering 11 UG, 15 PG, and 11 PhD courses in various streams of Computer Engineering, Electronic Engineering, etc. The top companies taking part in the NSIT placements drive are Accenture, Amazon, Birlasoft, Honda, HCL, Honda, Microsoft, Birla, Honeywell, Google, IBM, and many more. Since its inception, the institute has grown in size and scope. Every year it tries to bring new courses for the students to diversify their learning experience.",
            "Dwarka, Delhi"
        )
        addCollege(college)
        college = College(
            " Indraprastha Institute of Information Technology Delhi (IIIT-D)",
            2008,
            "IIIT-D",
            "gs://cloud-firestore-6a33c.appspot.com/logo_IIITD.jpg",
            "gs://cloud-firestore-6a33c.appspot.com/photo_IIITD.jpeg",
            "Established in 2008, Indraprastha Institute of Information Technology, Delhi (also known as IIIT Delhi or IIIT-D) is a state-level institute which initially started with its first batch of 60 students. The main campus of the institute is located in Okhla and it is approved by the University Grants Commission (UGC). IIIT Delhi is also a member of the Association of Indian Universities (AIU) and accredited by the NAAC with Grade 'A'. The institute is funded by the Government of Delhi and it ensures administrative and academic autonomy. IIIT Delhi has set up an R&D lab in collaboration with IRISYS Corporation Limited, South Korea. IIIT Delhi has slipped down to rank 75 under the 'Engineering' category of the NIRF Rankings 2023. Earlier, the institute ranked 63 under the 'Engineering' category in NIRF 2022. The institute has signed an MoU with UNIST, for a period of five years to promote academic cooperation between both the two institutes.",
            "Okhla, Delhi"
        )
        addCollege(college)
        college = College(
            "Indira Gandhi Delhi Technical University for Women (IGDTUW)",
            1998,
            "IGDTUW",
            "gs://cloud-firestore-6a33c.appspot.com/logo_IGDTUW.png",
            "gs://cloud-firestore-6a33c.appspot.com/photo_IGDTUW.webp",
            "Indira Gandhi Delhi Technical University for Women (IGDTUW) was established as the first engineering college for women only. The University is recognised by the UGC and is a member of the Association of Indian Universities. It has been ranked 161 among the best Engineering colleges in India by NIRF and seventh-best Engineering colleges in Delhi by NIRF 2021. IGDTUW offers BTech, BArch, BBA, MTech, MPlan, MCA, and PhD programmes in various specialisations. It also organises international conferences, workshops and seminars. IGDTUW has world-class infrastructure and offers all the required facilities to students, including accommodation facilities, a Wi-Fi facility, well-equipped labs, spacious classrooms and a central library. IGDTUW placement 2021 has names of top recruiters like Google, Deutsche Bank, Morgan Stanley, Nestle, American Bank, etc. There were 333 full-time employment offers that include 93 PPOs and 53 dual offers. Around 160 students were offered summer internships and the highest stipend offered was INR 1,60,000 per month. The highest salary offered was INR 59.45 LPA and the average salary was INR 19.15 LPA.",
            "Kashmere Gate, Delhi"
        )
        addCollege(college)
        college = College(
            "Delhi Skill and Entrepreneurship University (DSEU)",
            2020,
            "DSEU",
            "gs://cloud-firestore-6a33c.appspot.com/logo_DSEU.png",
            "gs://cloud-firestore-6a33c.appspot.com/photo_DSEU.jpg",
            "Delhi Skill and Entrepreneurship University was established in 2020 by the Government of NCT of Delhi. The university, through 12 schools of study, offers UG, PG, diploma, and various other courses to students. The courses are offered across Engineering, Computer Application, and various other streams. The university is approved by UGC and AICTE. ",
            "Dwarka, Delhi"
        )
        addCollege(college)
    }
    private fun addCollege(college: College){
        val db = FirebaseFirestore.getInstance()
        val TAG = "AddingData"
        db.collection("Colleges")
            .add(college)
            .addOnSuccessListener {
                Log.d(TAG, "DocumentSnapshot written with ID: ${it.id}")
            }
            .addOnFailureListener {
                Log.w(TAG, "Error adding document", it)
            }
    }
    private suspend fun getListOfColleges(): List<DocumentSnapshot>{
        val db = FirebaseFirestore.getInstance()
        val snapshot = db.collection("Colleges").get().await()
        return snapshot.documents
    }

    suspend fun getCollegeData(): ArrayList<College>{
//        val collegeList: ArrayList<College> = arrayListOf()
        val collegeData: ArrayList<College> = arrayListOf()
//        val db = FirebaseFirestore.getInstance()
//        db.collection("Colleges")
//            .get()
//            .addOnSuccessListener {
//                if(!it.isEmpty){
//                    val collegeList: ArrayList<College> = arrayListOf()
//                    for(data in it.documents){
//                        val college: College? = data.toObject(College::class.java)
//                        if (college != null) {
//                            collegeList.add(college)
//                        }
//                    }
//                    for(college in collegeList){
//                        collegeData.add(college)
//                    }
//                    Log.d("GettingData", "Success with ${collegeData.isEmpty()}")
//                }
//            }
//            .addOnFailureListener {
//                Log.d("GettingData", "Error getting document", it)
//            }
////        return collegeList
//        Log.d("GettingData", "Success with ${collegeData.isEmpty()}")
        try {
            val collegeList = getListOfColleges()
            for(dS in collegeList){
                val college:College? = dS.toObject(College::class.java)
                if(college != null){
                    collegeData.add(college)
                }
            }
        } catch (e: Exception){
            Log.d("Fetching Data","${e.message}")
        }
        return collegeData
    }
}


