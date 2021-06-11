package br.com.zup.edu

import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)

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

    val response = client.send(request)
    println(response)
}