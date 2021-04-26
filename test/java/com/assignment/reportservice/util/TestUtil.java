package com.assignment.reportservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.assignment.reportservice.domain.AccountStateChange;
import com.assignment.reportservice.domain.CurrencyWalletState;

public final class TestUtil {

	private static final Long ACCOUNT_ID = 10L;
	private static final Double AVAILABLE_AMOUNT_AFTER_TRANSACTION = 20.0;
	private static final Double BALANCE = 20.0;
	private static final String ESTONIA = "ESTONIA";
	private static final String DESCRIPTION = "ReportService Test";
	private static final String DIRECTION = "IN";
	private static final Double TRANSACTION_AMOUNT = 10.0;
	private static final Long TRANSACTION_CURRENCY_ID = 1L;
	private static final Double TRANSACTION_EXCHANGE_RATE = 8.385376;
	private static final Long SEK_CURR_ID = 1L;
	private static final String SEK_CURR_CODE = "SEK";
	private static final Double SEK_CURR_EXCH_RATE = 8.385376;
	private static final Double SEK_CURR_INVRS_EXCH_RATE = 0.119255;
	private static final Long EUR_CURR_ID = 2L;
	private static final String EUR_CURR_CODE = "EUR";
	private static final Double EUR_CURR_EXCH_RATE = 0.826609;
	private static final Double EUR_CURR_INVRS_EXCH_RATE = 1.209762;

	public static AccountStateChange getAccountStateChange() {
		AccountStateChange accountStateChange = new AccountStateChange();
		accountStateChange.setAccountId(ACCOUNT_ID);
		accountStateChange.setAvailableAmount(AVAILABLE_AMOUNT_AFTER_TRANSACTION);
		accountStateChange.setBalance(BALANCE);
		accountStateChange.setCountry(ESTONIA);
		accountStateChange.setCurrencyWalletStates(getCurrencyWalletState());
		accountStateChange.setCustomerId(UUID.randomUUID().toString());
		accountStateChange.setDescription(DESCRIPTION);
		accountStateChange.setDirection(DIRECTION);
		accountStateChange.setTransactionAmount(TRANSACTION_AMOUNT);
		accountStateChange.setTransactionCurrencyId(TRANSACTION_CURRENCY_ID);
		accountStateChange.setTransactionExchangeRate(TRANSACTION_EXCHANGE_RATE);
		accountStateChange.setTransactionId(UUID.randomUUID().toString());
		return accountStateChange;
	}

	private static List<CurrencyWalletState> getCurrencyWalletState() {
		List<CurrencyWalletState> currencyWalletStates = new ArrayList<>();
		CurrencyWalletState sekCurrencyWalletState = new CurrencyWalletState();
		sekCurrencyWalletState.setCurrencyId(SEK_CURR_ID);
		sekCurrencyWalletState.setCurrency(SEK_CURR_CODE);
		sekCurrencyWalletState.setExchangeRate(SEK_CURR_EXCH_RATE);
		sekCurrencyWalletState.setInverseExchangeRate(SEK_CURR_INVRS_EXCH_RATE);
		CurrencyWalletState eurCurrencyWalletState = new CurrencyWalletState();
		eurCurrencyWalletState.setCurrencyId(EUR_CURR_ID);
		eurCurrencyWalletState.setCurrency(EUR_CURR_CODE);
		eurCurrencyWalletState.setExchangeRate(EUR_CURR_EXCH_RATE);
		eurCurrencyWalletState.setInverseExchangeRate(EUR_CURR_INVRS_EXCH_RATE);
		currencyWalletStates.add(sekCurrencyWalletState);
		currencyWalletStates.add(eurCurrencyWalletState);
		return currencyWalletStates;
	}

	public static AccountStateChange getAccountTransactionStateChange() {
		AccountStateChange accountStateChange = getAccountStateChange();
		accountStateChange.setDirection(null);
		accountStateChange.setTransactionAmount(null);
		accountStateChange.setTransactionCurrencyId(null);
		accountStateChange.setTransactionExchangeRate(null);
		accountStateChange.setTransactionId(null);
		return accountStateChange;
	}

}
