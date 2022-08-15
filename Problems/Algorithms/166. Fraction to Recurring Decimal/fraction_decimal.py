class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return "0"

        ans = ""
        if numerator * denominator < 0:
            ans = "-"
        numerator = abs(numerator)
        denominator = abs(denominator)

        integer, rest = 0, numerator
        if numerator > denominator:
            integer = numerator // denominator
            rest = numerator % denominator

        if rest == 0:
            return ans + str(integer)
        else:
            ans += str(integer) + "."

        seen = {}
        rest *= 10
        idx = 0
        while rest not in seen:
            seen[rest] = idx

            div = rest // denominator
            rest %= denominator

            ans += str(div)
            if rest == 0:
                return ans

            rest *= 10
            idx += 1

        pos = seen[rest]
        integer, decimal = ans.split('.')
        decimal = decimal[:pos] + "(" + decimal[pos:] + ")"
        ans = integer + "." + decimal

        return ans

