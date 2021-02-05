package com.example.yournight

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.rpc.context.AttributeContext
import kotlinx.android.synthetic.main.fragment_settings.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var firebaseAuth: FirebaseAuth
        var mAuthListener: AuthStateListener

        firebaseAuth = FirebaseAuth.getInstance()
/*
        mAuthListener = AuthStateListener {
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                accedi.text = "Benvenuto!"
            }
        } */

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            accedi.text = "Benvenuto!"
            logOut.visibility = View.VISIBLE
        } else {
            logOut.visibility = View.INVISIBLE
            accedi.text = "Accedi"
        }

        logOut.setOnClickListener {
            Log.d("logout", "log out")
            FirebaseAuth.getInstance().signOut();
        }

        accedi.setOnClickListener {
            openLogin()
        }

        termini.setOnClickListener {
            openTermini()
        }

    }

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {

            }
    }

    fun openLogin() {
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
    }

    fun openTermini() {
        val intent = Intent(activity, Termini_CondizioniActivity::class.java)
        startActivity(intent)
    }

}