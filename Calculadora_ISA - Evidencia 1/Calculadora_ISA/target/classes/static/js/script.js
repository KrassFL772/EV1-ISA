document.getElementById('iacForm').addEventListener('submit', (e) => {
    e.preventDefault();

    const nombre = (document.getElementById('nombre').value || '').trim();
    const genero = (document.getElementById('genero').value || '').trim();
    const altura = parseFloat(document.getElementById('altura').value);
    const cadera = parseFloat(document.getElementById('cadera').value);

    if (!nombre || !genero || isNaN(altura) || isNaN(cadera) || altura <= 0 || cadera <= 0) {
        alert('Por favor ingresa valores válidos.');
        return;
    }

    const persona = { nombre, genero, altura, cadera };

    // Calcular localmente y mostrar inmediatamente
    persona.iac = calcularIACLocal(persona.cadera, persona.altura);
    persona.clasificacion = clasificarIACLocal(persona.iac, persona.genero);

    mostrarResultadoLocal(persona);

    // (Opcional) enviar al backend en segundo plano
    fetch('/api/iac/calcular', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(persona)
    }).catch(()=>{/* ignorar errores */});
});

function calcularIACLocal(caderas, altura) {
    return (caderas / Math.pow(altura, 1.5)) - 18;
}

function clasificarIACLocal(iac, genero) {
    if (/^M$/i.test(genero)) {
        if (iac < 20) return 'Bajo peso';
        if (iac <= 25) return 'Peso normal';
        return 'Sobrepeso/Obesidad';
    }
    if (/^F$/i.test(genero)) {
        if (iac < 25) return 'Bajo peso';
        if (iac <= 30) return 'Peso normal';
        return 'Sobrepeso/Obesidad';
    }
    return 'Género desconocido';
}

function mostrarResultadoLocal(resultado) {
    const nombreEl = document.getElementById('resultadoNombre');
    const valorIAC = document.getElementById('valorIAC');
    const clasEl = document.getElementById('valorClasificacion');
    if (nombreEl) nombreEl.textContent = `Resultado para: ${resultado.nombre}`;
    if (valorIAC) valorIAC.textContent = Number(resultado.iac).toFixed(2);
    if (clasEl) {
        clasEl.textContent = resultado.clasificacion;
        clasEl.className = 'valor-clasificacion';
        if (resultado.clasificacion === 'Bajo peso') clasEl.classList.add('bajo-peso');
        else if (resultado.clasificacion === 'Peso normal') clasEl.classList.add('peso-normal');
        else clasEl.classList.add('sobrepeso-obesidad');
    }
    const resultadoCard = document.getElementById('resultado');
    if (resultadoCard) {
        resultadoCard.classList.remove('hidden');
        resultadoCard.classList.add('show');
        resultadoCard.scrollIntoView({ behavior: 'smooth', block: 'center' });
    }
}

function limpiarFormulario() {
    document.getElementById('iacForm').reset();
    const resultadoCard = document.getElementById('resultado');
    if (resultadoCard) resultadoCard.classList.add('hidden');
}