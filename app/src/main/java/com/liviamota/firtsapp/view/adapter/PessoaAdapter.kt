package com.liviamota.firtsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liviamota.firtsapp.R
import com.liviamota.firtsapp.databinding.ListItemPessoaBinding
import com.liviamota.firtsapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener:(Pessoa)-> Unit):
 RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

     //criar uma lista vazia de pessoas
     private var pessoaList:List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
        RecyclerView.ViewHolder(binding.root) {

            //carrega as informações da pessoa na lista
        fun bind(pessoa: Pessoa, clickListListener:(Pessoa)-> Unit){
            binding.tvNome.text = pessoa.nome
            binding.tvNome.text = pessoa.idade.toString() +" anos"
            binding.tvFaixaEtaria.text = pessoa.faixaEtaria

                if (pessoa.sexo == "Masculino"){
                    binding.imgSexo.setImageResource(R.drawable.baseline_boy_24)
                }else{
                    binding.imgSexo.setImageresource(R.drawable.baseline_girl_24)
                }

            binding.root.setOnClickListener{
                clickListListener(pessoa)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PessoaAdapter.PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun onBindViewHolder(holder: PessoaAdapter.PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    override fun getItemCount(): Int {
      return pessoaList.count()
    }

    //carrega a lista de pessoas para serem exibidas
    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}