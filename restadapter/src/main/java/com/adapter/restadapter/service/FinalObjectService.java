package com.adapter.restadapter.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.adapter.restadapter.model.BvcSymboInfo;
import com.adapter.restadapter.model.DataObject;
import com.adapter.restadapter.model.EquitiesInfo;
import com.adapter.restadapter.model.ExecReport;
import com.adapter.restadapter.model.Header;
import com.adapter.restadapter.model.MecSymbolInfo;
import com.adapter.restadapter.model.Party;
import com.adapter.restadapter.model.Payload;
import com.adapter.restadapter.model.SecurityList;

@RefreshScope
@Service
public class FinalObjectService {
	private static final Logger LOG = LogManager.getLogger(FinalObjectService.class);
	
	@Value("${TTV}")
	private String TTV;
	
	@Value("${REPO}")
	private String REPO;
	
	public Payload getPayload(DataObject obj) {		
		Payload load = new Payload();
		Header head = new Header();
		BvcSymboInfo bvcSymbol = new BvcSymboInfo();
		ExecReport execR = new ExecReport();
		SecurityList security = new SecurityList();
		MecSymbolInfo mecSymbol = new MecSymbolInfo();
		EquitiesInfo eqInfo = new EquitiesInfo();
		
		try {
			
			head.setMarket(obj.getMERCADO());
			head.setSourceTime(obj.getHORA_TRAMA());
			head.setSourceId(Integer.parseInt(obj.getTIPO_TRAMA()+obj.getCODIGO()+obj.getDIGITO()));
			bvcSymbol.setISIN(obj.getCOD_ISIN());
			bvcSymbol.setReinv(obj.getREINVERSION());
			bvcSymbol.setTransaction(obj.getTRANSACCION());
			bvcSymbol.setLiqTerm(obj.getPLA_LIQUIDACION());
			bvcSymbol.setTrdSimType(obj.getTIPO_SIMULTANEA());
			bvcSymbol.setCaptureValue(Double.valueOf(obj.getVAL_CAPTACION()));
			bvcSymbol.setMktType(obj.getTIPO_MERCADO());
			bvcSymbol.setAllowed(obj.getRADICADO());
			bvcSymbol.setPTI(obj.getPTI());
			bvcSymbol.setPET(obj.getPET());
			bvcSymbol.setSeqType(Integer.parseInt(obj.getSEQTYPE()));
			bvcSymbol.setSeqNumber(Integer.parseInt(obj.getSEQNUMBER()));
			bvcSymbol.setHoraOpe(obj.getHORAOPE());
			
			execR.setExecType(obj.getESTADO());
			execR.setTransactTime(obj.getHORA_OPERACION());
			execR.setRdMatchID(Integer.parseInt(obj.getFOLIO()));
			execR.setSide(obj.getPUNTA());
			execR.setSymbol(obj.getMNEMOTECNICO());
			execR.setSettlDate(Integer.parseInt(obj.getFEC_CUMPLIMIENTO().replaceFirst("^0+(?!$)", "")));
			execR.setSettlType(Integer.parseInt(obj.getDIAS_CUMPLIMIENTO().replaceFirst("^0+(?!$)", "")));
			execR.setGrossTradeAmt(Double.valueOf(obj.getMONTO()));
//			execR.setYield();  In doubt
			execR.setIsPreArrenged(obj.getPRE_ACORDADO());
			execR.setStipulationValue(Double.valueOf(obj.getPRE_LIMPIO()));
			execR.setSecuritySubType(obj.getRUEDA_NEGOCIACION());
			execR.setGetSide(obj.getORIG_PUNTA());
			
			List<Party> pList = new ArrayList<Party>();
			pList.add(new Party(obj.getAFILIADO(),1));
			pList.add(new Party(obj.getTRADER(),11));
			pList.add(new Party(obj.getCOD_CORR(),12));
			pList.add(new Party(obj.getCONTRAPARTE(),17));
			pList.add(new Party(obj.getBROKEREFCOMPRA(),3));
			pList.add(new Party(obj.getBROKEREFVENTA(),3));
			execR.setParty(pList);
			
			if(obj.getRUEDA_NEGOCIACION().equalsIgnoreCase(TTV)) {
				execR.setLastPx(Double.valueOf(obj.getTASA_TTV()));
			}
			else if(obj.getRUEDA_NEGOCIACION().equalsIgnoreCase(REPO)) {
				execR.setLastPx(Double.valueOf(obj.getTASA_REPO()));
				execR.setYield(obj.getPLA_REPO()); // 	check
				execR.setSettlDate(Integer.parseInt(obj.getFEC_REPO().replaceFirst("^0+(?!$)", "")));
				execR.setLastQty(Integer.parseInt(obj.getMON_REPO().replaceFirst("^0+(?!$)", "")));
			}
			else {
				execR.setYield(obj.getTASA_REFERENCIA());
				execR.setLastQty(Long.parseLong(obj.getCANTIDAD().replaceFirst("^0+(?!$)", "")));
				execR.setLastPx(Double.valueOf(obj.getPRECIO()));
			}
			
			security.setCurrency(obj.getMONEDA());
			security.setCurrencyValue(Double.valueOf(obj.getVAL_MONEDA()));
			
			mecSymbol.setAdjRate(Double.valueOf(obj.getPTOS_TASA_REFERENCIA()));
			mecSymbol.setCalcBase(obj.getBASE_CALCULO());
			mecSymbol.setPriodicity(obj.getPERIODICIDAD());
			mecSymbol.setDuration(Double.valueOf(obj.getDURACION()));
			mecSymbol.setTrdCon(obj.getTIPO_OPERACION_CONTINUA());
			mecSymbol.setLote(obj.getLOTE());
			mecSymbol.setTrdTTV(obj.getTIPO_OPERACION_SERIALIZADA());
			mecSymbol.setSymType(obj.getTIPO_TITULO());
			mecSymbol.setModality(obj.getMODALIDAD());
			mecSymbol.setTrdType(obj.getTIPO_OPERACION());
			mecSymbol.setSymEst(obj.getEST_TITULO());
			mecSymbol.setExpiryDays(obj.getDIAS_VENCIMIENTO());
			mecSymbol.setExpiryDate(Integer.parseInt(obj.getFEC_VENCIMIENTO().replaceFirst("^0+(?!$)", "")));
			mecSymbol.setIssueDate(Integer.parseInt(obj.getFEC_EMISION().replaceFirst("^0+(?!$)", "")));
			mecSymbol.setIssueTerm(Integer.parseInt(obj.getPLA_EMISION().replaceFirst("^0+(?!$)", "")));
			mecSymbol.setIssueRate(Double.valueOf(obj.getTASA_EMISION()));
			mecSymbol.setSettlementCode(obj.getCOD_CUMPLIMIENTO());
			mecSymbol.setIsShortSell(obj.getVENTA_CORTO());
			
			eqInfo.setFungible(Integer.parseInt(obj.getFUNGIBLE()));
			eqInfo.setExdividend(obj.getEXDIVIDENDO());
			eqInfo.setMarketPrice(obj.getFIJA_PRECIO());
			
			load.setHeader(head);
			load.setBvcSymboInfo(bvcSymbol);
			load.setExecReport(execR);
			load.setMecSymbolInfo(mecSymbol);
			load.setSecurityList(security);
			load.setEquitiesInfo(eqInfo);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return load;
	}
	
}
