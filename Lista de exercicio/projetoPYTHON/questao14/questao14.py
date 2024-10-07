class Configuracao:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Configuracao, cls).__new__(cls)
        return cls._instance

def executar_questao14():
    config1 = Configuracao()
    config2 = Configuracao()
    
    print(config1 is config2) 
