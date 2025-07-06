package mrkinfotech.formulagrid.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.databinding.FragmentLoginBinding
import mrkinfotech.formulagrid.ui.home.HomeMainActivity
import mrkinfotech.formulagrid.utils.CustomDialog
import mrkinfotech.formulagrid.utils.PreferenceHelper


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpButton.setOnClickListener {
           findNavController().navigate(R.id.SignUpFragment)
        }

        binding.buttonSignIn.setOnClickListener {
            val email = binding.enterEmail.text.toString()
            val pass = binding.enterPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(requireContext(), HomeMainActivity::class.java))
                        PreferenceHelper.setUserEmail(requireContext(),email)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            it.exception.toString(),
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            } else {
                CustomDialog.showToast(requireContext(), "Empty fields are not allowed")

            }
        }
    }
}