package com.credium.importloans

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.credium.data.Loan
import com.credium.data.LoansProvider
import com.credium.net.LoansService
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


class ImportLoansViewModel : ViewModel() {

    private var job: Job? = null

    val importedLoansInfo = MutableLiveData<ImportedLoansInfo>()
    private var newLoans: List<Loan>? = null

    fun startImportingLoans() {
        job = launch(UI) {
            delay(2000)
            newLoans = LoansService.fetchLoans()
            val info = ImportedLoansInfo(
                    loanCount = newLoans!!.size,
                    totalAmount = newLoans!!.sumBy { it.amount },
                    currency = newLoans!!.first().currency.label
            )
            importedLoansInfo.postValue(info)
        }
    }

    fun clearLoans() {
        newLoans = null
    }

    fun saveLoans() {
        newLoans?.let { LoansProvider.addLoans(it) }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
