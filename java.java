function calcular() {
    const valor1 = parseFloat(document.getElementById('valor1').value) || 0;
    const valor2 = parseFloat(document.getElementById('valor2').value) || 0;
    const operacao = document.getElementById('operacao').value;
    let resultado = '';

    const operacoes = {
        '+': `${valor1} + ${valor2} = ${valor1 + valor2}`,
        '-': `${valor1} - ${valor2} = ${valor1 - valor2}`,
        '*': `${valor1} × ${valor2} = ${(valor1 * valor2).toFixed(2)}`,
        '/': valor2 !== 0 ? `${valor1} ÷ ${valor2} = ${(valor1 / valor2).toFixed(4)}` : 'Erro: Divisão por zero!',
        'potencia': `${valor1}ʸ${valor2} = ${Math.pow(valor1, valor2).toFixed(4)}`,
        'raiz': valor1 >= 0 ? `√${valor1} = ${Math.sqrt(valor1).toFixed(4)}` : 'Erro: Raiz de número negativo!',
        'fatorial': fatorial(valor1),
        'fib': fibonacci(valor1)
    };

    resultado = operacoes[operacao] || 'Operação inválida';
    document.getElementById('resultado').innerHTML = resultado;
}

function fatorial(n) {
    if (n < 0 || !Number.isInteger(n)) return 'Erro: Fatorial só para inteiros ≥ 0';
    if (n === 0 || n === 1) return `${n}! = 1`;
    
    let resultado = 1;
    for (let i = 2; i <= n; i++) {
        resultado *= i;
    }
    return `${n}! = ${resultado}`;
}

function fibonacci(n) {
    if (n < 0 || !Number.isInteger(n)) return 'Erro: Fibonacci só para inteiros ≥ 0';
    if (n === 0) return 'Fibonacci(0) = 0';
    if (n === 1) return 'Fibonacci(1) = 1';
    
    let fib = [0, 1];
    for (let i = 2; i <= n; i++) {
        fib[i] = fib[i-1] + fib[i-2];
    }
    return `Fibonacci(${n}) = ${fib[n]}`;
}