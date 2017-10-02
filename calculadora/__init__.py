from typing import List, Union

Number = Union[int, float]


class Analisador(object):
    @classmethod
    def eh_valida(cls, expressao: str) -> bool:
        return None

    @classmethod
    def tokenizar(cls, expressao: str) -> List[str]:
        return None


class Avaliador(object):
    @classmethod
    def avaliar(cls, expressao: str) -> Number:
        return float('NaN')
