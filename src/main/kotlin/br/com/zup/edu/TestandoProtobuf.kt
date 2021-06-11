package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Bruno Silva")
        .setCpf("000.000.000-00")
        .setSalario(45000.77)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua das Xampoulas Douradas")
            .setCep("00000-000")
            .setComplemento("Casa 171")
            .build())
        .build()

    println(request)

    // Escrevendo o obj em disco
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    // Lendo o obj do disco
    val response = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))
    response.setCargo(Cargo.GERENTE)
    println(response)
}