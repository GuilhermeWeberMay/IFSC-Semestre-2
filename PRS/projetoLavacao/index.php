<?php
// =================================================================
// 1. ESTRUTURA DAS CLASSES PHP
// =================================================================

class Cliente
{
 public $id;
 public $nome;
 public $contato;

 public function salvar()
 { /* Lógica para salvar no banco de dados */
 }
 public function buscarPorId($id)
 { /* Lógica para buscar no banco de dados */
 }
 public function atualizar()
 { /* Lógica para atualizar no banco de dados */
 }
 public function deletar()
 { /* Lógica para deletar no banco de dados */
 }
 public function listarHistorico()
 { /* Lógica para buscar o histórico de faturas */
  return [];
 }
} 

class Veiculo
{
 public $id;
 public $clienteId;
 public $tipo; // 1-Pequeno, 2-Médio, 3-Grande

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function validarTipo()
 {
  return true;
 }
}

class Servico
{
 public $id;
 public $nome;
 public $tipo; // 1-Externa, 2-Completa, 3-Completa+Cera

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function validarTipo()
 {
  return true;
 }
}

class Preco
{
 public $id;
 public $tipoVeiculo;
 public $tipoServico;
 public $valor;

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function buscarPreco($tipoVeiculo, $tipoServico)
 { /* Lógica para consultar o preço na matriz */
  return 0.0;
 }
 public function validarTipos()
 {
  return true;
 }
}

class Agendamento
{
 public $id;
 public $clienteId;
 public $veiculoId;
 public $servicoId;
 public $dataHora;

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function calcularPreco()
 {
  return 0.0;
 }
 public function consultarPrecos()
 {
  return [];
 }
}

class Fatura
{
 public $id;
 public $agendamentoId;
 public $valorFinal;
 public $dataEmissao;

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function processarPagamento()
 { /* ... */
 }
 public function gerarFatura()
 { /* Cria uma fatura com base em um agendamento */
 }
}

class Funcionario
{
 public $id;
 public $nome;
 public $cargo;

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function atualizarEstagio($agendamentoId, $estagio)
 { /* Atualiza o status de um agendamento no banco */
 }
}

class Relatorio
{
 public $id;
 public $tipo;

 public function gerar()
 { /* ... */
 }
 public function exportar()
 { /* ... */
 }
 public function calcularFaturamento($periodo)
 {
  return 0.0;
 }
 public function listarServicosCliente($clienteId)
 {
  return [];
 }
 public function calcularQuantidadeServicos($periodo)
 {
  return 0;
 }
}

class Proprietario
{
 public $id;
 public $nome;
 public $contato;

 public function salvar()
 { /* ... */
 }
 public function buscarPorId($id)
 { /* ... */
 }
 public function atualizar()
 { /* ... */
 }
 public function deletar()
 { /* ... */
 }
 public function gerenciarPrecos()
 { /* ... */
 }
}

// Fim da definição das classes PHP. O HTML começa abaixo.
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Sistema de Gestão - Lava-Car</title>

 <!-- ================================================================= -->
 <!-- 2. ESTILO CSS EMBUTIDO                                            -->
 <!-- ================================================================= -->
 <style>
  @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');

  :root {
   --primary-color: #10B981;
   --primary-hover: #0f9b6c;
   --text-color: #1F2937;
   --text-light: #6B7280;
   --bg-color: #F8F9FA;
   --card-bg: #FFFFFF;
   --border-color: #E5E7EB;
  }

  * {
   margin: 0;
   padding: 0;
   box-sizing: border-box;
  }

  body {
   font-family: 'Inter', sans-serif;
   background-color: var(--bg-color);
   color: var(--text-color);
   line-height: 1.6;
  }

  .container {
   max-width: 1200px;
   margin: 2rem auto;
   padding: 0 1rem;
   display: grid;
   gap: 2rem;
  }

  header {
   background-color: var(--primary-color);
   color: white;
   padding: 1rem 0;
   text-align: center;
   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .card {
   background-color: var(--card-bg);
   border-radius: 8px;
   border: 1px solid var(--border-color);
   padding: 1.5rem;
   box-shadow: 0 1px 3px rgba(0, 0, 0, 0.05);
  }

  .card h2 {
   font-size: 1.25rem;
   margin-bottom: 1.5rem;
   display: flex;
   align-items: center;
   gap: 0.5rem;
  }

  table {
   width: 100%;
   border-collapse: collapse;
  }

  th,
  td {
   text-align: left;
   padding: 0.75rem 1rem;
   border-bottom: 1px solid var(--border-color);
  }

  th {
   font-weight: 600;
   color: var(--text-light);
   font-size: 0.8rem;
   text-transform: uppercase;
  }

  tbody tr:hover {
   background-color: #f5f5f5;
  }

  td a {
   color: var(--primary-color);
   text-decoration: none;
   font-weight: 500;
  }

  td a:hover {
   text-decoration: underline;
  }

  .status {
   padding: 0.25rem 0.6rem;
   border-radius: 12px;
   font-size: 0.8rem;
   font-weight: 500;
   color: white;
  }

  .status.em-lavagem {
   background-color: #3b82f6;
  }

  .status.na-fila {
   background-color: #f59e0b;
  }

  .form-grid {
   display: grid;
   grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
   gap: 1rem;
  }

  .form-group {
   display: flex;
   flex-direction: column;
  }

  .form-group.full-width {
   grid-column: 1 / -1;
  }

  .form-group label {
   margin-bottom: 0.5rem;
   font-weight: 500;
   font-size: 0.9rem;
  }

  .form-group input,
  .form-group select {
   padding: 0.75rem;
   border: 1px solid var(--border-color);
   border-radius: 6px;
   font-size: 1rem;
   font-family: 'Inter', sans-serif;
  }

  .form-group input:focus,
  .form-group select:focus {
   outline: none;
   border-color: var(--primary-color);
   box-shadow: 0 0 0 2px rgba(16, 185, 129, 0.2);
  }

  button {
   background-color: var(--primary-color);
   color: white;
   border: none;
   padding: 0.8rem 1.5rem;
   border-radius: 6px;
   font-size: 1rem;
   font-weight: 600;
   cursor: pointer;
   transition: background-color 0.2s;
   width: 100%;
  }

  button:hover {
   background-color: var(--primary-hover);
  }
 </style>
</head>

<body>
 <!-- ================================================================= -->
 <!-- 3. CORPO HTML DA APLICAÇÃO                                        -->
 <!-- ================================================================= -->
 <header>
  <h1>Painel de Gestão - Lava-Car</h1>
 </header>
 <main class="container">
  <section class="card">
   <h2><img src="https://img.icons8.com/office/24/000000/overtime.png" alt="ícone relógio" /> Agendamentos Atuais</h2>
   <table>
    <thead>
     <tr>
      <th>Cliente</th>
      <th>Veículo</th>
      <th>Serviço</th>
      <th>Status</th>
      <th>Ação</th>
     </tr>
    </thead>
    <tbody>
     <tr>
      <td>Guilherme Weber</td>
      <td>Carro Pequeno</td>
      <td>Lavação Completa</td>
      <td><span class="status em-lavagem">Em Lavagem</span></td>
      <td><a href="#">Ver Detalhes</a></td>
     </tr>
     <tr>
      <td>Ana Costa</td>
      <td>Carro Grande</td>
      <td>Completa + Cera</td>
      <td><span class="status na-fila">Na Fila</span></td>
      <td><a href="#">Ver Detalhes</a></td>
     </tr>
    </tbody>
   </table>
  </section>

  <section class="card">
   <h2><img src="https://img.icons8.com/office/24/000000/add-user-male.png" alt="ícone usuário" /> Cadastrar Novo Cliente</h2>
   <form class="form-grid" method="post">
    <div class="form-group">
     <label for="nome">Nome do Cliente:</label>
     <input type="text" id="nome" name="nome" required>
    </div>
    <div class="form-group">
     <label for="contato">Contato (Telefone):</label>
     <input type="text" id="contato" name="contato" required>
    </div>
    <div class="form-group full-width">
     <button type="submit">Salvar Cliente</button>
    </div>
   </form>
  </section>

  <section class="card">
   <h2><img src="https://img.icons8.com/office/24/000000/add-car.png" alt="ícone carro" /> Novo Agendamento</h2>
   <form class="form-grid" method="post">
    <div class="form-group">
     <label for="cliente">Cliente:</label>
     <select id="cliente" name="cliente">
      <option>Guilherme Weber</option>
      <option>Ana Costa</option>
     </select>
    </div>
    <div class="form-group">
     <label for="veiculo">Tipo de Veículo:</label>
     <select id="veiculo" name="veiculo">
      <option>Pequeno</option>
      <option>Médio</option>
      <option>Grande</option>
     </select>
    </div>
    <div class="form-group">
     <label for="servico">Tipo de Serviço:</label>
     <select id="servico" name="servico">
      <option>Lavação Externa</option>
      <option>Lavação Completa</option>
      <option>Completa + Cera</option>
     </select>
    </div>
    <div class="form-group full-width">
     <button type="submit">Criar Agendamento</button>
    </div>
   </form>
  </section>
 </main>
</body>

</html>