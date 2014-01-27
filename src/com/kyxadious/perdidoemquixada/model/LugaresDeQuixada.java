package com.kyxadious.perdidoemquixada.model;

import java.util.ArrayList;

public class LugaresDeQuixada {
	
	private ArrayList<Lugar> lugares;
	
	public LugaresDeQuixada() {
		lugares = new ArrayList<Lugar>();
	}
	
	public ArrayList<Lugar> getLugaresDeQuixada(){
		// do something 
		lugares.add(new Lugar("Raízes Bar & Restô", Tipo.RESTAURANTE, "Comida regional e música ao vivo", -4.969795, -39.014580, "Rua Rodrigues Júnior - Centro (Em frente ao Banco do Brasil)"));
		lugares.add(new Lugar("Irashai Mase",Tipo.RESTAURANTE, "Restaurante Asiático", -4.970529, -39.014952, "Rua José de Alencar, 547  - Centro"));
		lugares.add(new Lugar("Mac Lanches", Tipo.LANCHONETE, "Lanchonete", -4.969740, -39.013308, "Rua Rodrigues Júnior – Centro (Em frente a Praça Coronel Nanan)"));
		lugares.add(new Lugar("Nori", Tipo.RESTAURANTE, "Restaurante Asiático", -4.969689, -39.013404, "Rua Rodrigues Júnior, 759 - Centro"));
		lugares.add(new Lugar("Sorveteria Mix", Tipo.SORVETERIA, "Sorveteria", -4.969720, -39.016118, "Rua Rodrigues Júnior – Centro (Esquina com a Praça José de Barros)"));
		lugares.add(new Lugar("Q-doce", Tipo.LANCHONETE, "Lanchonete", -4.968622, -39.016185, "Rua Epitácio Pessoa, 1453 – Centro"));
		lugares.add(new Lugar("Bom D+", Tipo.RESTAURANTE, "Pizzaria e churrascaria", -4.968458, -39.015003, "Rua Epitácio Pessoa, 1322 - Centro"));
		lugares.add(new Lugar("Pastelaria O Marivaldo", Tipo.LANCHONETE, "Lanchonete e pastelaria", -4.971425, -39.018460, "Rua Rui Maia, 367 - Centro"));  
		lugares.add(new Lugar("Pizzaria Forno A Lenha", Tipo.PIZZARIA, "Pizzaria", 4.969287, -39.013309, "Rua Clarindo de José - Centro"));
		lugares.add(new Lugar("Restaurante Pé de Serra", Tipo.RESTAURANTE, "Restaurante e churrascaria", -5.045373, -39.048716, "Estrada do Algodão km 105"));
		lugares.add(new Lugar("Abrigo Bar", Tipo.BAR, "Bar", -4.969366, -39.013415, "Rua Clarindo de José - Centro"));
		lugares.add(new Lugar("Bar do Duarte", Tipo.BAR, "Bar", -4.971733, -39.014509, "Rua José Jucá -  Centro (Em frente a Praça da Cultura)"));
		lugares.add(new Lugar("Skina", Tipo.RESTAURANTE, "Restaurante", -4.970038, -39.018420, "Rua Basílio Pinto com Rua Rui Maia – Centro"));
		lugares.add(new Lugar("Le Gourmet Buffet Sushi", Tipo.RESTAURANTE, "Restaurante Asiático", -4.970572, -39.025604, "Rua José Freitas Queirós – Planalto Universitário"));
		lugares.add(new Lugar("Guloseimas", Tipo.LANCHONETE, "Lanchonete", -4.972459, -39.021846, "Av. José Caetano Almeida – Combate"));
		lugares.add(new Lugar("Dona Rita", Tipo.LANCHONETE, "Lanchonete",-4.969203, -39.024086, "Rua Jacinto Gomes - Planalto Universitário"));
		lugares.add(new Lugar("Rede Açaí.com", Tipo.LANCHONETE, "Lanchonete", -4.969788, -39.012025, "Rua Rodrigues Júnior – Bavieira"));
		lugares.add(new Lugar("Sabores Do sertão", Tipo.RESTAURANTE, "Restaurante", -4.968974, -39.015977, "Av. Plácido Castelo - Centro"));
		lugares.add(new Lugar("Bookafé", Tipo.LANCHONETE, "Lanchonete", -4.968542, -39.021347, "Rua José Queirós Pessoa – Planalto Universitário"));
		lugares.add(new Lugar("Pinheiro Supermercado", Tipo.SUPERMERCADO, "Supermercado", -4.968342, -39.017377, "Rua Francisco Enéas de Lima, 2027 – Centro")); 
		lugares.add(new Lugar("Lojas Americanas", Tipo.LOJA_DE_DEPARTAMENTO, "Loja de departamento", -4.968567, -39.014176, "Rua Epitácio Pessoa, 1250  - Centro"));
		lugares.add(new Lugar("Super São Geraldo Centro", Tipo.SUPERMERCADO, "Supermercado", -4.968863, -39.016883, "Rua Tabelião Enéas, 645 – Centro"));
		lugares.add(new Lugar("Super São Geraldo Alto São Francisco", Tipo.SUPERMERCADO, "Supermercado", -4.968489, -39.010171, "Rua Epitácio Pessoa, 783 – Alto São Francisco"));
		lugares.add(new Lugar("Super São Geraldo Campo Novo", Tipo.SUPERMERCADO, "Supermercado", -4.982347, -39.018639, "Av. Presidente Vargas, 740 – Campo Novo"));
		lugares.add(new Lugar("Mercantil Cícero Bertoldo", Tipo.SUPERMERCADO, "Supermercado", -4.970218, -39.016869, "Rua Tabelião Enéas, 473 – Centro"));
		lugares.add(new Lugar("Panificadora Nossa Senhora do Perpétuo Socorro", Tipo.PADARIA, "Padaria", -4.96737, -39.008908, "Rua Benjamim Constant, 1033 – Alto São Francisco"));
		lugares.add(new Lugar("Meu Escritório", Tipo.BAR, "Bar", -4.972604, -39.019667, "Av. José Caetano Almeida - Combate"));
		lugares.add(new Lugar("Hotel Nobile Express Vale das Pedras", Tipo.HOTEL, "Hotel com 130 leitos. Tel: (88) 3412-6610(Recepção) e (88) 3412- 6611 (Reservas)", -4.955973, -39.006972, "Av. Jesus Maria e José, 2010 – Jardim dos Monólitos"));
		lugares.add(new Lugar("Panificadora Q-Pão", Tipo.PADARIA, "Padaria", -4.968577, -39.014989, "Rua Epitácio Pessoa, 1325 – Centro"));
		lugares.add(new Lugar("Self-Service Saborear", Tipo.RESTAURANTE, "Restaurante", -4.969793, -39.015778, "Rua Rodrigues Júnior, 1342 – Centro"));
		lugares.add(new Lugar("Peixada O Abelardo", Tipo.RESTAURANTE, "Peixada, tilápia frita, camarão, baião de dois, etc.", -4.962918, -39.015393, "Av. Placido Castelo, 2585 – Triângulo"));
		lugares.add(new Lugar("Restaurante Itajubá", Tipo.RESTAURANTE, "Restaurante", -4.962864, -39.024237, "Rodovia CE 456 Km 01 – São João"));
		lugares.add(new Lugar("Churrascaria Eudásio do Baião", Tipo.RESTAURANTE, "Baião de dois, carne de sol, carne de porco, linguiça etc.", -4.965748, -39.010419, "Rua Benigno Bezerra, 82 – Campo Velho"));
		lugares.add(new Lugar("Panificadora e Confeitaria Sete de Setembro", Tipo.PADARIA, "Padaria", -4.965742, -39.010268, "Rua Benigno Bezerra, 94 – Campo Velho"));
		lugares.add(new Lugar("Panificadora Uberlândia", Tipo.PADARIA, "Padaria", -4.968604, -39.020843, "Rua José de Queirós Pessoa – Planalto Universitário"));
		lugares.add(new Lugar("Rei do Lanche", Tipo.RESTAURANTE, "Restaurante bom e barato (feito para universitários)", -4.973459, -39.016786, "Rua Sebastião Enéas – Centro (atrás da rodoviária)"));
		lugares.add(new Lugar("Mr. Mix Milk Shakes", Tipo.SORVETERIA, "Sorveteria", -4.969791, -39.01618, "Av. Plácido Castelo – Centro (próximo da Sorveteria Mix)")); 
		lugares.add(new Lugar("Hotel Nova Aldeota", Tipo.HOTEL, "Hotel com 45 leitos. Tel: (88) 3412-2147", -4.953864, -39.004878, "Av. Jesus Maria e José - Jardim dos Monólitos"));
		lugares.add(new Lugar("Hotel Monólitos", Tipo.HOTEL, "Hotel com 50 leitos. Tel: (88) 3412-8080", -4.972444, -39.016252, "Av. Plácido Castelo – Centro"));
		lugares.add(new Lugar("Hotel Belas Artes", Tipo.HOTEL, "Hotel com 80 leitos. Tel: (88) 3412-0188", -4.995496, -39.032252, "Estrada do Algodão, km 96"));
		lugares.add(new Lugar("Hotel Itajubá", Tipo.HOTEL, "Hotel com 28 leitos. Tel. (88) 3412-3675", -4.962886, -39.024356, "Rodovia CE 456 Km 01 – São João"));
		lugares.add(new Lugar("Banco do Brasil", Tipo.BANCO, " Tel: (88) 3412-0034", -4.969745, -39.01445, "Rua Rodrigues Júnior, 1202 – Centro"));
		lugares.add(new Lugar("Bradesco", Tipo.BANCO, "Tel: (88) 3412-5521 / 3412-5310 / 3412-5170", -4.969155, -39.01438, "Travessa Tiradentes, 230 – Centro"));  
		lugares.add(new Lugar("Banco do Nordeste", Tipo.BANCO, "Tel: (88) 3412-0179", -4.970606, -39.015515, "Rua Pascoal Crispino, 215 – Centro"));
		lugares.add(new Lugar("Caixa Econômica Federal", Tipo.BANCO, "Tel: (88) 3412-0444 / 3412-0964 / 3412-0807", -4.96939, -39.018449, "Rua Rui Maia, 580 – Centro"));
		lugares.add(new Lugar("Farmácia Pague Menos", Tipo.FARMACIA, "Farmácia", -4.970614, -39.016342, "Av. Plácido Castelo, 1785 – Centro"));
		lugares.add(new Lugar("Drogarias Feitosa", Tipo.FARMACIA, "Farmácia", -4.969586, -39.015971, "Rua Rodrigues Júnior, 1372 – Centro"));
		lugares.add(new Lugar("Extrafarma", Tipo.FARMACIA, "Farmácia", -4.968893, -39.016658, "Rua Tabelião Enéas, 628 – Centro"));
		lugares.add(new Lugar("Farmácia Menino Jesus", Tipo.FARMACIA, "Farmácia", -4.969756, -39.012613, "Rua Rodrigues Júnior, 1005 – Irajá"));
		lugares.add(new Lugar("Caroá Restaurante", Tipo.RESTAURANTE, "Restaurante", -4.957100, -39.006322, "Av. Jesus Maria e José, 2010 – Jardim dos Monólitos"));
		lugares.add(new Lugar("Delegacia Regional de Polícia Civil de Quixadá", Tipo.POLICIA, "Delegacia da 12ª Região. Tel: (88) 3445-1047", -4.972113, -39.028507, "Rua Brasílio Pinto, 1445 - Combate"));
		lugares.add(new Lugar("9° Batalhão da Polícia Militar de Quixadá", Tipo.POLICIA, "Polícia Militar. Tel: (88) 3445-1042 / 190", -4.964684, -39.011339, "Rua Tenente Cravo – Campo Velho"));
		lugares.add(new Lugar("Detran de Quixadá", Tipo.DETRAN, "Tel: (88) 3345-1060 / 3345-1057", -4.969689, -39.026965, "Rua José Enéas Monteiro Lessa, 980 - Planalto Universitário"));
		lugares.add(new Lugar("Hospital Dr. Eudásio Barroso", Tipo.HOSPITAL, "Tel: (88) 3412-8556", -4.967752, -39.022223, "Praça João Brasileiro Filho, 2324 – Centro"));
		lugares.add(new Lugar("Hospital Maternidade Jesus Maria José", Tipo.HOSPITAL, "Tel: (88) 3412-0681", -4.967752, -39.022223, "Av. Francisco Almeida Pinheiro, 2268 – Planalto Universitário"));
		lugares.add(new Lugar("Universidade Federal do Ceará – Campus Quixadá", Tipo.FACULDADE, "UFC – Campus Quixadá", -4.979325, -39.056247, "Av. José de Freitas Queiros, 5003 – Cedro Novo"));
		lugares.add(new Lugar("Faculdade de Educação, Ciências e Letras do Sertão Central", Tipo.FACULDADE, "UECE / FECLESC", -4.968406, -39.02457, "Rua José de Queiroz Pessoa, 2554 – Planalto Universitário"));
		lugares.add(new Lugar("Instituto Federal do Ceará – Campus Quixadá", Tipo.FACULDADE, "IFCE – Campus Quixadá", -4.978336, -39.058141, "Estrada do Açude Cedro, Km 05 – Cedro Novo"));
		lugares.add(new Lugar("Faculdade Católica Rainha do Sertão", Tipo.FACULDADE, "FCRS", -4.975268, -39.016014, "Av. Plácido Castelo – Centro / Rua Juvêncio Alves, 660 – Centro"));
		
		
		return lugares;
	}

}
