package com.example.tdd_junit4_kotlin

import com.example.tdd_junit4_kotlin.ui.model.Auction
import com.example.tdd_junit4_kotlin.ui.model.Bid
import com.example.tdd_junit4_kotlin.ui.model.User
import junit.framework.TestCase.assertEquals
import org.junit.Test

class AuctionTest {
    private val DELTA = 0.0001
    private val HENRIQUE = User("Henrique")
    private val AUCTION = Auction("Console")

    @Test
    fun getDescricao_QuandoRecebeDescricao_DevolveDescricao() {
        val descricaoDevolvida = AUCTION.description
        assertEquals("Console", descricaoDevolvida)
    }

    @Test
    fun deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        AUCTION.propose(Bid(HENRIQUE, 200.0))

        val maiorLance = AUCTION.getBiggerBid()
        assertEquals(200.0, maiorLance, DELTA)
    }
    @Test
    fun deve_DevolveMiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        AUCTION.propose(Bid(HENRIQUE, 200.0))
        AUCTION.propose(Bid(User("Zequinha"), 300.0))

        val maiorLance = AUCTION.getBiggerBid()
        assertEquals(300.0, maiorLance, DELTA)
    }
    @Test
    fun deve_DevolveMiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        AUCTION.propose(Bid(HENRIQUE, 200.0))
        AUCTION.propose(Bid(User("Zequinha"), 300.0))

        val maiorLance = AUCTION.getBiggerBid()
        assertEquals(300.0, maiorLance, DELTA)
    }
    @Test
    fun deve_DeveVolverMenorLance_QuandoRecebeUmLance() {
        AUCTION.propose(Bid(HENRIQUE, 200.0))

        val maiorLance = AUCTION.getSmallerBid()
        assertEquals(200.0, maiorLance, DELTA)
    }
    @Test
    fun deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        AUCTION.propose(Bid(HENRIQUE, 8000.0))
        AUCTION.propose(Bid(User("Zequinha"), 10000.0))

        assertEquals(8000.0, AUCTION.getSmallerBid(), DELTA)
    }
    @Test
    fun deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        AUCTION.propose(Bid(User("Zequinha"), 1090.0))
        AUCTION.propose(Bid(HENRIQUE, 990.0))

        assertEquals(990.0, AUCTION.getSmallerBid(), DELTA)
    }
    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances() {
        AUCTION.propose(Bid(HENRIQUE, 200.0))
        AUCTION.propose(Bid(User("Zequinha"), 400.0))
        AUCTION.propose(Bid(User("Juquinha"), 300.0))

        val tresMaioresLancesDevolvidos = AUCTION.threeBiggersAuction()
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValue(), DELTA)
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValue(), DELTA)
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValue(), DELTA)
    }
    @Test
    fun deve_DevolverTresMaioresLances_QuandoNaoRecebeLance() {

        val tresMaioresLancesDevolvidos = AUCTION.threeBiggersAuction()
        assertEquals(0, tresMaioresLancesDevolvidos.size)
    }

    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeApenasUmLance() {
        AUCTION.propose(Bid(HENRIQUE, 400.0))

        val tresMaioresLancesDevolvidos = AUCTION.threeBiggersAuction()
        assertEquals(1, tresMaioresLancesDevolvidos.size)
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValue(), DELTA)
    }
    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeApenasDoisLances() {
        AUCTION.propose(Bid(HENRIQUE, 400.0))
        AUCTION.propose(Bid(User("Zequinha"), 200.0))

        val tresMaioresLancesDevolvidos = AUCTION.threeBiggersAuction()
        assertEquals(2, tresMaioresLancesDevolvidos.size)
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValue(), DELTA)
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(1).getValue(), DELTA)
    }
    @Test
    fun deve_DevolverTresMaioresLances_QuandoRecebeMaisDeTresLances() {
        AUCTION.propose(Bid(HENRIQUE, 600.0))
        val ZEQ = User("Zequinha")
        AUCTION.propose(Bid(ZEQ, 200.0))
        AUCTION.propose(Bid(HENRIQUE, 400.0))
        AUCTION.propose(Bid(ZEQ, 300.0))
        AUCTION.propose(Bid(HENRIQUE, 200.0))

        val tresMaioresLancesDevolvidos = AUCTION.threeBiggersAuction()

        assertEquals(600.0, tresMaioresLancesDevolvidos.get(0).getValue(), DELTA)
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(1).getValue(), DELTA)
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(2).getValue(), DELTA)
    }

}