package com.kyxadious.perdidoemquixada.model;

import java.util.ArrayList;

import com.kyxadious.perdidoemquixada.R;

public class LugaresDeQuixada {
	
	
	public LugaresDeQuixada() {
		
	}
	
	public ArrayList<Lugar> getLugaresDeQuixada(){
		
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		
		lugares.add(new Lugar("Raízes Bar & Restô", R.drawable.ic_raizes_bar, Tipo.RESTAURANTE, "Comida regional e música ao vivo", -4.969796,-39.014659, "Rua Rodrigues Júnior - Centro (Em frente ao Banco do Brasil)"));
		lugares.add(new Lugar("Irashai Mase", R.drawable.ic_irashai, Tipo.RESTAURANTE, "Restaurante Asiático", -4.970529, -39.014952, "Rua José de Alencar, 547  - Centro"));
		lugares.add(new Lugar("Mac Lanches", R.drawable.ic_mac_lanches, Tipo.LANCHONETE, "Lanchonete", -4.9697,-39.013342, "Rua Rodrigues Júnior – Centro (Em frente a Praça Coronel Nanan)"));
		lugares.add(new Lugar("Nori – Sushis e Restô", R.drawable.ic_nori, Tipo.RESTAURANTE, "Restaurante Asiático", -4.969772,-39.013401, "Rua Rodrigues Júnior, 759 - Centro"));
		lugares.add(new Lugar("Sorveteria Mix", R.drawable.ic_sorveteria_mix, Tipo.SORVETERIA, "Sorveteria", -4.969769,-39.016126, "Rua Rodrigues Júnior – Centro (Esquina com a Praça José de Barros)"));
		lugares.add(new Lugar("Q-doce", R.drawable.ic_q_doce, Tipo.LANCHONETE, "Lanchonete", -4.968622, -39.016185, "Rua Epitácio Pessoa, 1453 – Centro"));
		lugares.add(new Lugar("Bom D+", R.drawable.ic_bom_demais, Tipo.RESTAURANTE, "Restaurante e Pizzaria", -4.968543,-39.015, "Rua Epitácio Pessoa, 1322 - Centro"));
		lugares.add(new Lugar("Pastelaria O Marivaldo", R.drawable.ic_marivaldo, Tipo.LANCHONETE, "Lanchonete e pastelaria", -4.971425, -39.018460, "Rua Rui Maia, 367 - Centro"));  
		lugares.add(new Lugar("Pizzaria Forno A Lenha", R.drawable.ic_forno_lenha, Tipo.PIZZARIA, "Pizzaria", -4.969307, -39.013366, "Rua Clarindo de José - Centro"));
		lugares.add(new Lugar("Restaurante Pé de Serra", R.drawable.ic_pe_serra, Tipo.RESTAURANTE, "Restaurante e churrascaria", -5.045373, -39.048716, "Estrada do Algodão km 105"));
		lugares.add(new Lugar("Abrigo Bar", R.drawable.ic_abrigo_bar, Tipo.BAR, "Bar", -4.96928, -39.013444, "Rua Clarindo de José - Centro"));
		lugares.add(new Lugar("Bar do Duarte", R.drawable.ic_duarte, Tipo.BAR, "Bar", -4.971733, -39.014509, "Rua José Jucá -  Centro (Em frente a Praça da Cultura)"));
		lugares.add(new Lugar("Skina", R.drawable.ic_skina, Tipo.RESTAURANTE, "Restaurante", -4.970038, -39.018420, "Rua Basílio Pinto com Rua Rui Maia – Centro"));
		lugares.add(new Lugar("Le Gourmet Buffet Sushi", R.drawable.ic_le_gourmet, Tipo.RESTAURANTE, "Restaurante Asiático", -4.970707,-39.025578, "Rua José Freitas Queirós – Planalto Universitário"));
		lugares.add(new Lugar("Guloseimas", R.drawable.ic_guloseimas, Tipo.LANCHONETE, "Lanchonete", -4.972459, -39.021846, "Av. José Caetano Almeida – Combate"));
		lugares.add(new Lugar("Dona Rita", R.drawable.ic_dona_rita, Tipo.LANCHONETE, "Lanchonete",-4.969203, -39.024086, "Rua Jacinto Gomes - Planalto Universitário"));
		lugares.add(new Lugar("Rede Açaí.com", R.drawable.ic_rede_acai, Tipo.LANCHONETE, "Lanchonete", -4.969788, -39.012025, "Rua Rodrigues Júnior – Bavieira"));
		lugares.add(new Lugar("Sabores Do sertão", R.drawable.ic_sabores_sertao, Tipo.RESTAURANTE, "Restaurante", -4.968974, -39.015977, "Av. Plácido Castelo - Centro"));
		lugares.add(new Lugar("Bookafé", R.drawable.ic_bookafe, Tipo.LANCHONETE, "Lanchonete", -4.968542, -39.021347, "Rua José Queirós Pessoa – Planalto Universitário"));
		lugares.add(new Lugar("Pinheiro Supermercado", R.drawable.ic_pinheiro_super, Tipo.SUPERMERCADO, "Supermercado", -4.968316,-39.017392, "Rua Francisco Enéas de Lima, 2027 – Centro")); 
		lugares.add(new Lugar("Lojas Americanas", R.drawable.ic_americanas, Tipo.LOJA_DE_DEPARTAMENTO, "Loja de departamento", -4.968527,-39.014308, "Rua Epitácio Pessoa, 1250  - Centro"));
		lugares.add(new Lugar("Super São Geraldo Centro", R.drawable.ic_geraldo, Tipo.SUPERMERCADO, "Supermercado", -4.968893,-39.016917, "Rua Tabelião Enéas, 645 – Centro"));
		lugares.add(new Lugar("Super São Geraldo Alto São Francisco", R.drawable.ic_geraldo, Tipo.SUPERMERCADO, "Supermercado", -4.968543,-39.010244, "Rua Epitácio Pessoa, 783 – Alto São Francisco"));
		lugares.add(new Lugar("Super São Geraldo Campo Novo", R.drawable.ic_geraldo, Tipo.SUPERMERCADO, "Supermercado", -4.982256,-39.018682, "Av. Presidente Vargas, 740 – Campo Novo"));
		lugares.add(new Lugar("Mercantil Cícero Bertoldo", R.drawable.ic_bertoldo, Tipo.SUPERMERCADO, "Supermercado", -4.970218, -39.016869, "Rua Tabelião Enéas, 473 – Centro"));
		lugares.add(new Lugar("Panificadora Nossa Senhora do Perpétuo Socorro", R.drawable.ic_perpetuo_socorro, Tipo.PADARIA, "Padaria", -4.967394,-39.008906, "Rua Benjamim Constant, 1033 – Alto São Francisco"));
		lugares.add(new Lugar("Meu Escritório", R.drawable.ic_meu_escritorio, Tipo.BAR, "Bar", -4.972644,-39.019565, "Av. José Caetano Almeida - Combate"));
		lugares.add(new Lugar("Hotel Nobile Express Vale das Pedras", R.drawable.ic_vale_pedras, Tipo.HOTEL, "Hotel com 130 leitos. Tel: (88) 3412-6610(Recepção) e (88) 3412- 6611 (Reservas)", -4.955997,-39.006942, "Av. Jesus Maria e José, 2010 – Jardim dos Monólitos"));
		lugares.add(new Lugar("Panificadora Q-Pão", R.drawable.ic_q_pao, Tipo.PADARIA, "Padaria", -4.968599,-39.014962, "Rua Epitácio Pessoa, 1325 – Centro"));
		lugares.add(new Lugar("Self-Service Saborear", R.drawable.ic_saborear, Tipo.RESTAURANTE, "Restaurante", -4.969775,-39.015756, "Rua Rodrigues Júnior, 1342 – Centro"));
		lugares.add(new Lugar("Peixada O Abelardo", R.drawable.ic_abelardo, Tipo.RESTAURANTE, "Peixada, tilápia frita, camarão, baião de dois, etc.", -4.962918,-39.015474, "Av. Placido Castelo, 2585 – Triângulo"));
		lugares.add(new Lugar("Restaurante Itajubá", R.drawable.ic_rest_itajuba, Tipo.RESTAURANTE, "Restaurante", -4.962864, -39.024237, "Rodovia CE 456 Km 01 – São João"));
		lugares.add(new Lugar("Churrascaria Eudásio do Baião", R.drawable.ic_eudasio_baiao, Tipo.RESTAURANTE, "Baião de dois, carne de sol, carne de porco, linguiça etc.", -4.965748, -39.010419, "Rua Benigno Bezerra, 82 – Campo Velho"));
		lugares.add(new Lugar("Panificadora e Confeitaria Sete de Setembro", R.drawable.ic_sete_setembeo, Tipo.PADARIA, "Padaria", -4.965742, -39.010268, "Rua Benigno Bezerra, 94 – Campo Velho"));
		lugares.add(new Lugar("Panificadora Uberlândia", R.drawable.ic_uberlandia, Tipo.PADARIA, "Padaria", -4.968639,-39.020791, "Rua José de Queirós Pessoa – Planalto Universitário"));
		lugares.add(new Lugar("O Rei do Lanche", R.drawable.ic_rei_lanche, Tipo.RESTAURANTE, "Restaurante bom e barato (feito para universitários)", -4.97343,-39.016816, "Rua Sebastião Enéas – Centro (atrás da rodoviária)"));
		lugares.add(new Lugar("Mr. Mix Milk Shakes", R.drawable.ic_mr_mix, Tipo.SORVETERIA, "Sorveteria", -4.969785,-39.016293, "Av. Plácido Castelo – Centro (próximo da Sorveteria Mix)")); 
		lugares.add(new Lugar("Hotel Nova Aldeota", R.drawable.ic_hotel_nova_aldeota, Tipo.HOTEL, "Hotel com 45 leitos. Tel: (88) 3412-2147", -4.953864, -39.004878, "Av. Jesus Maria e José - Jardim dos Monólitos"));
		lugares.add(new Lugar("Hotel Monólitos", R.drawable.ic_hotel_monolitos, Tipo.HOTEL, "Hotel com 50 leitos. Tel: (88) 3412-8080", -4.97234,-39.016504, "Av. Plácido Castelo – Centro"));
		lugares.add(new Lugar("Hotel Belas Artes", R.drawable.ic_hotel_belas_artes, Tipo.HOTEL, "Hotel com 80 leitos. Tel: (88) 3412-0188", -4.995656,-39.032021, "Estrada do Algodão, km 96"));
		lugares.add(new Lugar("Hotel Itajubá", R.drawable.ic_hotel_itajuba, Tipo.HOTEL, "Hotel com 28 leitos. Tel. (88) 3412-3675", -4.962886, -39.024356, "Rodovia CE 456 Km 01 – São João"));
		lugares.add(new Lugar("Banco do Brasil", R.drawable.ic_banco_brasil, Tipo.BANCO, " Tel: (88) 3412-0034", -4.969718,-39.014458, "Rua Rodrigues Júnior, 1202 – Centro"));
		lugares.add(new Lugar("Bradesco", R.drawable.ic_banco_bradesco, Tipo.BANCO, "Tel: (88) 3412-5521 / 3412-5310 / 3412-5170", -4.969155, -39.01438, "Travessa Tiradentes, 230 – Centro"));  
		lugares.add(new Lugar("Banco do Nordeste", R.drawable.ic_banco_nordeste, Tipo.BANCO, "Tel: (88) 3412-0179", -4.970606, -39.015515, "Rua Pascoal Crispino, 215 – Centro"));
		lugares.add(new Lugar("Caixa Econômica Federal", R.drawable.ic_banco_caixa, Tipo.BANCO, "Tel: (88) 3412-0444 / 3412-0964 / 3412-0807", -4.96939, -39.018449, "Rua Rui Maia, 580 – Centro"));
		lugares.add(new Lugar("Farmácia Pague Menos", R.drawable.ic_pague_menos, Tipo.FARMACIA, "Farmácia", -4.970614, -39.016342, "Av. Plácido Castelo, 1785 – Centro"));
		lugares.add(new Lugar("Drogarias Feitosa", R.drawable.ic_feitosa, Tipo.FARMACIA, "Farmácia", -4.969758,-39.016038, "Rua Rodrigues Júnior, 1372 – Centro"));
		lugares.add(new Lugar("Extrafarma", R.drawable.ic_extra_farma, Tipo.FARMACIA, "Farmácia", -4.968952,-39.016824, "Rua Tabelião Enéas, 628 – Centro"));
		lugares.add(new Lugar("Farmácia Menino Jesus", R.drawable.ic_menino_jesus, Tipo.FARMACIA, "Farmácia", -4.969777,-39.012682, "Rua Rodrigues Júnior, 1005 – Irajá"));
		lugares.add(new Lugar("Caroá Restaurante", R.drawable.ic_caroa, Tipo.RESTAURANTE, "Restaurante", -4.957100, -39.006322, "Av. Jesus Maria e José, 2010 – Jardim dos Monólitos"));
		lugares.add(new Lugar("Delegacia Regional de Polícia Civil de Quixadá", R.drawable.ic_delegacia, Tipo.POLICIA, "Delegacia da 12ª Região. Tel: (88) 3445-1047", -4.972113, -39.028507, "Rua Brasílio Pinto, 1445 - Combate"));
		lugares.add(new Lugar("9° Batalhão da Polícia Militar de Quixadá", R.drawable.ic_quartel, Tipo.POLICIA, "Polícia Militar. Tel: (88) 3445-1042 / 190", -4.964684, -39.011339, "Rua Tenente Cravo – Campo Velho"));
		lugares.add(new Lugar("Detran de Quixadá", R.drawable.ic_detran_qx, Tipo.DETRAN, "Tel: (88) 3345-1060 / 3345-1057", -4.969689, -39.026965, "Rua José Enéas Monteiro Lessa, 980 - Planalto Universitário"));
		lugares.add(new Lugar("Hospital Dr. Eudásio Barroso", R.drawable.ic_hospital_eudasio, Tipo.HOSPITAL, "Tel: (88) 3412-8556", -4.967752, -39.022223, "Praça João Brasileiro Filho, 2324 – Centro"));
		lugares.add(new Lugar("Hospital Maternidade Jesus Maria José", R.drawable.ic_maternidade, Tipo.HOSPITAL, "Tel: (88) 3412-0681", -4.967586, -39.024964, "Av. Francisco Almeida Pinheiro, 2268 – Planalto Universitário"));
		lugares.add(new Lugar("Universidade Federal do Ceará – Campus Quixadá", R.drawable.ic_ufc, Tipo.FACULDADE, "UFC – Campus Quixadá", -4.979325, -39.056247, "Av. José de Freitas Queiros, 5003 – Cedro Novo"));
		lugares.add(new Lugar("Faculdade de Educação, Ciências e Letras do Sertão Central", R.drawable.ic_uece, Tipo.FACULDADE, "UECE / FECLESC", -4.968406, -39.02457, "Rua José de Queiroz Pessoa, 2554 – Planalto Universitário"));
		lugares.add(new Lugar("Instituto Federal do Ceará – Campus Quixadá", R.drawable.ic_ifce, Tipo.FACULDADE, "IFCE – Campus Quixadá", -4.978336, -39.058141, "Estrada do Açude Cedro, Km 05 – Cedro Novo"));
		lugares.add(new Lugar("Faculdade Católica Rainha do Sertão", R.drawable.ic_fcrs, Tipo.FACULDADE, "FCRS", -4.975268, -39.016014, "Av. Plácido Castelo – Centro / Rua Juvêncio Alves, 660 – Centro"));
		
		
		return lugares;
	}

}
