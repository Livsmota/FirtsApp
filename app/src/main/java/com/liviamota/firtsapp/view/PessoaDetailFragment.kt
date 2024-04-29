
package com.liviamota.firtsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.liviamota.firtsapp.R
import com.liviamota.firtsapp.databinding.FragmentPessoaBinding
import com.liviamota.firtsapp.databinding.FragmentPessoaDetailBinding
import com.liviamota.firtsapp.viewmodel.PessoaViewModel

class PessoaDetailFragment : Fragment() {
    //chamar viewModel para pegar dados
    private val viewModel: PessoaViewModel by viewModels()

    //criar o binding para pegar elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null

    private val binding: FragmentPessoaDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pessoa_detail, container, false)
    }

    //chamar a função onViewCreated onde vamos implementar o código
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Pegar o id da pessoa que foi enviado pela AllPessoaFragment
        // Setar a pessoa para ser carregada
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaID"))
        }

        //carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner){pessoa ->
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString() + "anos"
            binding.tvFaixaEtaria.text = pessoa.faixaEtaria

            if (pessoa.sexo == "Masculino"){
                binding.imgSexo.setImageResource(R.drawable.baseline_boy_24)
            }else{
                binding.imgSexo.setImageresource(R.drawable.baseline_girl_24)
            }
        }
    }
}