package mrkinfotech.formulagrid.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.databinding.FragmentLoginBinding
import mrkinfotech.formulagrid.ui.home.HomeMainActivity
import mrkinfotech.formulagrid.utils.PreferenceHelper


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignIn.setOnClickListener {
            val userEmail = binding.enterEmail.text.toString()
            val password = binding.enterPassword.text.toString()
            if (userEmail == "xyz@gmail.com" && password == "123") {
                PreferenceHelper.setUserEmail(requireContext(),userEmail)
                startActivity(Intent(requireContext(), HomeMainActivity::class.java))
                findNavController().navigate(R.id.HomeFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Enter valid Username and Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.SignUpFragment)
        }
    }
}