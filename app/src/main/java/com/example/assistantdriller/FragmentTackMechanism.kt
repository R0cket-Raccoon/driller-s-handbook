package com.example.assistantdriller

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistantdriller.databinding.FragmentListOfCategoriesBinding
import com.example.assistantdriller.databinding.FragmentTackMechanismBinding
import com.example.assistantdriller.mechanism.AdapterMechanism
import com.example.assistantdriller.mechanism.Mechanism
import com.example.assistantdriller.mechanism.MechanismData


class FragmentTackMechanism : Fragment(),AdapterMechanism.Result {
    lateinit var binding: FragmentTackMechanismBinding
    private val adapter = AdapterMechanism(Mechanism().mechanism(), this)
    private var check = true
    var list = mutableListOf<AnswerSheetData>(
        AnswerSheetData(-1, -1, -1),
        AnswerSheetData(-1, -1, -1),
        AnswerSheetData(-1, -1, -1),
        AnswerSheetData(-1, -1, -1),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTackMechanismBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerMechanism.adapter = adapter
        binding.recyclerMechanism.layoutManager = LinearLayoutManager(this.context)
        binding.result.setOnClickListener {
            if (check) {
                arguments?.getBoolean("meh")?.let {
                    val listResult = max(list)
                    Log.d("list", list.toString())
                    Log.d("listResult", listResult.toString())
                    if (checkingForLice(list)) {
                        for (i in listResult.indices) {
                            Log.d("i", i.toString())
                            Log.d("listResult[i]", listResult[i].toString())
                            if (listResult[i] == 0) print(i, it)
                        }
                        check = false
                    } else Toast.makeText(this.context, R.string.Error, Toast.LENGTH_SHORT).show()

                }
            } else {
                clearTheResult()
                check = true
            }
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(args: Bundle?): FragmentTackMechanism {
            val fragment = FragmentTackMechanism()
            fragment.arguments = args
            return fragment
        }

    }

    override fun result(id: Int, mechanismData: MechanismData) {
        Log.d("id", id.toString())
        when (mechanismData.number) {

            0 -> when (id) {
                R.id.answer_one -> {
                    list[0].oneMechanism = 2
                    list[0].twoMechanism = 0
                    list[0].threeMechanism = 2
                }
                R.id.answer_two -> {
                    list[0].oneMechanism = 1
                    list[0].twoMechanism = 0
                    list[0].threeMechanism = 2

                }
                R.id.answer_three -> {
                    list[0].oneMechanism = 2
                    list[0].twoMechanism = 2
                    list[0].threeMechanism = 0

                }
            }
            1 -> when (id) {
                R.id.answer_one -> {
                    list[1].oneMechanism = 0
                    list[1].twoMechanism = 0
                    list[1].threeMechanism = 2
                }
                R.id.answer_two -> {
                    list[1].oneMechanism = 1
                    list[1].twoMechanism = 0
                    list[1].threeMechanism = 2
                }
                R.id.answer_three -> {
                    list[1].oneMechanism = 0
                    list[1].twoMechanism = 0
                    list[1].threeMechanism = 0
                }
            }
            2 -> when (id) {
                R.id.answer_one -> {
                    list[2].oneMechanism = 0
                    list[2].twoMechanism = 0
                    list[2].threeMechanism = 2
                }
                R.id.answer_two -> {
                    list[2].oneMechanism = 2
                    list[2].twoMechanism = 0
                    list[2].threeMechanism = 2
                }
                R.id.answer_three -> {
                    list[2].oneMechanism = 0
                    list[2].twoMechanism = 0
                    list[2].threeMechanism = 0
                }
            }
            3 -> when (id) {
                R.id.answer_one -> {
                    list[3].oneMechanism = 0
                    list[3].twoMechanism = 2
                    list[3].threeMechanism = 2
                }
                R.id.answer_two -> {
                    list[3].oneMechanism = 2
                    list[3].twoMechanism = 0
                    list[3].threeMechanism = 0
                }
                R.id.answer_three -> {
                    list[3].oneMechanism = 2
                    list[3].twoMechanism = 0
                    list[3].threeMechanism = 0
                }
            }
        }
    }

    private fun max(list: List<AnswerSheetData>): List<Int> {
        val summList = mutableListOf<Int>(0, 0, 0)
        var max = 0
        for (i in list.indices) {
            summList[0] = summList[0] + list[i].oneMechanism
            summList[1] = summList[1] + list[i].twoMechanism
            summList[2] = summList[2] + list[i].threeMechanism
            Log.d("колличество", i.toString())
        }
        max = summList.maxOrNull()!!
        for (i in summList.indices) {
            summList[i] = summList[i] - max
        }
        return summList
    }

    private fun print(number: Int, boolean: Boolean) {
        binding.recyclerMechanism.visibility = View.GONE
        binding.result.setText(R.string.Restart)
        binding.scrollView.smoothScrollTo(0,0)
        when (number) {
            0 -> {
                binding.textResult1.visibility = View.VISIBLE
                binding.textResultHeading1.visibility = View.VISIBLE
                if (boolean) {
                    binding.textResultHeading1.setText(R.string.SlamPrihvat)
                    binding.textResult1.setText(R.string.ListOfSlamPrihvat)

                } else {
                    binding.textResultHeading1.setText(R.string.OKPorodaPrihvat)
                    binding.textResult1.setText(R.string.ListOfOKPorodaPrihvat)
                }
            }
            1 -> {
                Log.d("2q", "рисует")
                binding.textResult2.visibility = View.VISIBLE
                binding.textResultHeading2.visibility = View.VISIBLE
                if (boolean) {
                    binding.textResult2.setText(R.string.ListOfDiffPrihvat)
                    binding.textResultHeading2.setText(R.string.DiffPrihvat)
                } else {
                    binding.textResult2.setText(R.string.ListOfOKDiffPrihvat)
                    binding.textResultHeading2.setText(R.string.OKDiffPrihvat)
                }
            }
            2 -> {
                binding.textResult3.visibility = View.VISIBLE
                binding.textResultHeading3.visibility = View.VISIBLE
                if (boolean) {
                    binding.textResult3.setText(R.string.ListOFGeomPrihvat)
                    binding.textResultHeading3.setText(R.string.GeomPrihvat)
                } else {
                    binding.textResult3.setText(R.string.ListOFSpuskGeomPrihvat)
                    binding.textResultHeading3.setText(R.string.SpuskGeomPrihvat)
                }
            }

        }
    }

    private fun checkingForLice(list: List<AnswerSheetData>): Boolean {
        for (i in list.indices) {
            if (list[i].oneMechanism == -1 || list[i].twoMechanism == -1 || list[i].threeMechanism == -1) {
                return false
            }
        }
        return true
    }

    private fun clearTheResult() {
        list = mutableListOf<AnswerSheetData>(
            AnswerSheetData(-1, -1, -1),
            AnswerSheetData(-1, -1, -1),
            AnswerSheetData(-1, -1, -1),
            AnswerSheetData(-1, -1, -1),
        )
        binding.apply {
            result.setText(R.string.Go)
            textResult1.visibility = View.GONE
            textResult2.visibility = View.GONE
            textResult3.visibility = View.GONE
            textResultHeading1.visibility = View.GONE
            textResultHeading2.visibility = View.GONE
            textResultHeading3.visibility = View.GONE
            recyclerMechanism.visibility = View.VISIBLE
            recyclerMechanism.adapter = adapter
        }
        binding.scrollView.smoothScrollTo(0,0)
        binding.recyclerMechanism.layoutManager = LinearLayoutManager(this.context)


    }
}

data class AnswerSheetData(
    var oneMechanism:Int,
    var twoMechanism:Int,
    var threeMechanism:Int,

)