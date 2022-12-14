package com.nttdata.microservice.bankpassiveaccounts.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankpassiveaccounts.collections.MovementsCollection;
import com.nttdata.microservice.bankpassiveaccounts.collections.PassiveAccountCollection;
import com.nttdata.microservice.bankpassiveaccounts.collections.enums.MovementTypeEnum;
import com.nttdata.microservice.bankpassiveaccounts.dto.CurrentAccountPersonalDto;
import com.nttdata.microservice.bankpassiveaccounts.services.IMovementService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "movement")
public class MovementController {
	
	private static Logger logger = Logger.getLogger(PassiveAccountController.class);
	
	@Autowired
	private IMovementService service;
	
	/*@PostMapping(value = "/store")
	public Mono<MovementsCollection> saveMovement(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save movement");
		return movementService.save(collection);
	}
	*/
	
	/*@GetMapping("/findAll/{accountCode}")
	public Flux<MovementsCollection> getMovementsByAccountCode(@PathVariable("accountCode") String accountCode)
			throws Exception {
		logger.info("get movement by account code");
		return movementService.getByAccountCode(accountCode);
	}*/
	
	@PostMapping(value = "/saveDeposit")
	public Mono<MovementsCollection> saveDeposit(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save deposit");
		return service.saveDeposit(collection);
	}
	
	@PostMapping(value = "/saveWithdrawal")
	public Mono<MovementsCollection> saveWithdrawal(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save withdrawal");
		return service.saveWithdrawal(collection);
	}
	
	@PostMapping(value = "/saveTransferWithSameAccount")
	public Mono<MovementsCollection> saveTransferWithSameAccount(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save transfer with same account");
		return service.saveTransferWithSameAccount(collection);
	}
	
	@PostMapping(value = "/saveTransferThirdAccount")
	public Mono<MovementsCollection> saveTransferThirdAccount(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save transfer to third ascount");
		return service.saveTransferThirdAccount(collection);
	}
	
	@PostMapping(value = "/saveDepositWithDebitCard")
	public Mono<MovementsCollection> saveDepositWithDebitCard(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save deposit with debit card");
		return service.saveDepositWithDebitCard(collection);
	}
	
	@PostMapping(value = "/saveWithdrawalWithDebitCard")
	public Mono<MovementsCollection> saveWithdrawalWithDebitCard(@RequestBody MovementsCollection collection) throws Exception{
		logger.info("save withdrawal with debit card");
		return service.saveWithdrawalWithDebitCard(collection);
	}
	
}
