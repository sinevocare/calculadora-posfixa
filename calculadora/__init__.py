from typing import List, Union

Number = Union[int, float]


class Analisador(object):
    @classmethod
    def eh_valida(cls, expressao: str) -> bool:
        pass

    @classmethod
    def tokenizar(cls, expressao: str) -> List[str]:
        pass


class Avaliador(object):
    @classmethod
    def avaliar(cls, expressao: str) -> Number:
        pass
