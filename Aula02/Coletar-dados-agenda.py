# Coleta Dados do Usuário: Recebe uma lista de nomes e idades.
# Armazena Dados em um Dicionário: Usa um dicionário para associar cada nome à sua idade.
# Salva Dados em um Arquivo .txt: Grava os dados armazenados no dicionário em um arquivo de texto.
# Autor: Ricardo Roberto de Lima..

def coletar_dados():

    dados = {}
    while True:
        nome = input("Digite o nome (ou 'sair' para encerrar): ")
        if nome.lower() == 'sair':
            break
        idade = input("Digite a idade: ")
        try:
            idade = int(idade)
        except ValueError:
            print("Idade deve ser um número inteiro. Tente novamente.")
            continue
        
        dados[nome] = idade
    return dados

def salvar_em_arquivo(dados, nome_arquivo):
    with open(nome_arquivo, 'w') as arquivo:
        for nome, idade in dados.items():
            arquivo.write("Nome: {}, Idade: {}\n".format(nome, idade))

def main():

    dados = coletar_dados()
    if dados:
        salvar_em_arquivo(dados, 'dados_pessoas.txt')
        print("Dados salvos no arquivo 'dados_pessoas.txt'.")
    else:
        print("Nenhum dado foi coletado.")

if __name__ == "__main__":
    main()
