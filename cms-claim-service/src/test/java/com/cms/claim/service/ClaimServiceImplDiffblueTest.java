package com.cms.claim.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cms.claim.dao.ClaimDao;
import com.cms.claim.entity.Claim;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClaimServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClaimServiceImplDiffblueTest {
    @MockBean
    private ClaimDao claimDao;

    @Autowired
    private ClaimServiceImpl claimServiceImpl;

    /**
     * Method under test: {@link ClaimServiceImpl#addClaim(Claim)}
     */
    @Test
    void testAddClaim() {
        // Arrange
        Claim claim = new Claim();
        claim.setActionStatus("Action Status");
        claim.setAmtApprovedBySurveyor(new BigDecimal("2.3"));
        claim.setClaimAmount(new BigDecimal("2.3"));
        claim.setClaimApplicationDate("2020-03-01");
        claim.setClaimId("42");
        claim.setClaimStatus("Claim Status");
        claim.setCustomerClaimResponse("Customer Claim Response");
        claim.setCustomerId(1);
        claim.setDateOfAccident("2020-03-01");
        claim.setId(1);
        claim.setPolicyApplicationId(1);
        claim.setPolicyId(1);
        claim.setSurveyorId(1);
        when(claimDao.save(Mockito.<Claim>any())).thenReturn(claim);

        Claim claim2 = new Claim();
        claim2.setActionStatus("Action Status");
        claim2.setAmtApprovedBySurveyor(new BigDecimal("2.3"));
        claim2.setClaimAmount(new BigDecimal("2.3"));
        claim2.setClaimApplicationDate("2020-03-01");
        claim2.setClaimId("42");
        claim2.setClaimStatus("Claim Status");
        claim2.setCustomerClaimResponse("Customer Claim Response");
        claim2.setCustomerId(1);
        claim2.setDateOfAccident("2020-03-01");
        claim2.setId(1);
        claim2.setPolicyApplicationId(1);
        claim2.setPolicyId(1);
        claim2.setSurveyorId(1);

        // Act
        Claim actualAddClaimResult = claimServiceImpl.addClaim(claim2);

        // Assert
        verify(claimDao).save(isA(Claim.class));
        assertSame(claim, actualAddClaimResult);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#updateClaim(Claim)}
     */
    @Test
    void testUpdateClaim() {
        // Arrange
        Claim claim = new Claim();
        claim.setActionStatus("Action Status");
        claim.setAmtApprovedBySurveyor(new BigDecimal("2.3"));
        claim.setClaimAmount(new BigDecimal("2.3"));
        claim.setClaimApplicationDate("2020-03-01");
        claim.setClaimId("42");
        claim.setClaimStatus("Claim Status");
        claim.setCustomerClaimResponse("Customer Claim Response");
        claim.setCustomerId(1);
        claim.setDateOfAccident("2020-03-01");
        claim.setId(1);
        claim.setPolicyApplicationId(1);
        claim.setPolicyId(1);
        claim.setSurveyorId(1);
        when(claimDao.save(Mockito.<Claim>any())).thenReturn(claim);

        Claim claim2 = new Claim();
        claim2.setActionStatus("Action Status");
        claim2.setAmtApprovedBySurveyor(new BigDecimal("2.3"));
        claim2.setClaimAmount(new BigDecimal("2.3"));
        claim2.setClaimApplicationDate("2020-03-01");
        claim2.setClaimId("42");
        claim2.setClaimStatus("Claim Status");
        claim2.setCustomerClaimResponse("Customer Claim Response");
        claim2.setCustomerId(1);
        claim2.setDateOfAccident("2020-03-01");
        claim2.setId(1);
        claim2.setPolicyApplicationId(1);
        claim2.setPolicyId(1);
        claim2.setSurveyorId(1);

        // Act
        Claim actualUpdateClaimResult = claimServiceImpl.updateClaim(claim2);

        // Assert
        verify(claimDao).save(isA(Claim.class));
        assertSame(claim, actualUpdateClaimResult);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#getById(int)}
     */
    @Test
    void testGetById() {
        // Arrange
        Claim claim = new Claim();
        claim.setActionStatus("Action Status");
        claim.setAmtApprovedBySurveyor(new BigDecimal("2.3"));
        claim.setClaimAmount(new BigDecimal("2.3"));
        claim.setClaimApplicationDate("2020-03-01");
        claim.setClaimId("42");
        claim.setClaimStatus("Claim Status");
        claim.setCustomerClaimResponse("Customer Claim Response");
        claim.setCustomerId(1);
        claim.setDateOfAccident("2020-03-01");
        claim.setId(1);
        claim.setPolicyApplicationId(1);
        claim.setPolicyId(1);
        claim.setSurveyorId(1);
        Optional<Claim> ofResult = Optional.of(claim);
        when(claimDao.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        Claim actualById = claimServiceImpl.getById(1);

        // Assert
        verify(claimDao).findById(eq(1));
        assertSame(claim, actualById);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#getById(int)}
     */
    @Test
    void testGetById2() {
        // Arrange
        Optional<Claim> emptyResult = Optional.empty();
        when(claimDao.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        // Act
        Claim actualById = claimServiceImpl.getById(1);

        // Assert
        verify(claimDao).findById(eq(1));
        assertNull(actualById);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#getByCustomer(int)}
     */
    @Test
    void testGetByCustomer() {
        // Arrange
        ArrayList<Claim> claimList = new ArrayList<>();
        when(claimDao.findByCustomerId(Mockito.<Integer>any())).thenReturn(claimList);

        // Act
        List<Claim> actualByCustomer = claimServiceImpl.getByCustomer(1);

        // Assert
        verify(claimDao).findByCustomerId(eq(1));
        assertTrue(actualByCustomer.isEmpty());
        assertSame(claimList, actualByCustomer);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#getBySurveyor(int)}
     */
    @Test
    void testGetBySurveyor() {
        // Arrange
        ArrayList<Claim> claimList = new ArrayList<>();
        when(claimDao.findBySurveyorId(Mockito.<Integer>any())).thenReturn(claimList);

        // Act
        List<Claim> actualBySurveyor = claimServiceImpl.getBySurveyor(1);

        // Assert
        verify(claimDao).findBySurveyorId(eq(1));
        assertTrue(actualBySurveyor.isEmpty());
        assertSame(claimList, actualBySurveyor);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#getByPolicyApplicationId(Integer)}
     */
    @Test
    void testGetByPolicyApplicationId() {
        // Arrange
        ArrayList<Claim> claimList = new ArrayList<>();
        when(claimDao.findByPolicyApplicationId(Mockito.<Integer>any())).thenReturn(claimList);

        // Act
        List<Claim> actualByPolicyApplicationId = claimServiceImpl.getByPolicyApplicationId(1);

        // Assert
        verify(claimDao).findByPolicyApplicationId(eq(1));
        assertTrue(actualByPolicyApplicationId.isEmpty());
        assertSame(claimList, actualByPolicyApplicationId);
    }

    /**
     * Method under test: {@link ClaimServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        // Arrange
        ArrayList<Claim> claimList = new ArrayList<>();
        when(claimDao.findAll()).thenReturn(claimList);

        // Act
        List<Claim> actualAll = claimServiceImpl.getAll();

        // Assert
        verify(claimDao).findAll();
        assertTrue(actualAll.isEmpty());
        assertSame(claimList, actualAll);
    }

    /**
     * Method under test:
     * {@link ClaimServiceImpl#getByCustomerIdAndPolicyId(Integer, Integer)}
     */
    @Test
    void testGetByCustomerIdAndPolicyId() {
        // Arrange
        Claim claim = new Claim();
        claim.setActionStatus("Action Status");
        claim.setAmtApprovedBySurveyor(new BigDecimal("2.3"));
        claim.setClaimAmount(new BigDecimal("2.3"));
        claim.setClaimApplicationDate("2020-03-01");
        claim.setClaimId("42");
        claim.setClaimStatus("Claim Status");
        claim.setCustomerClaimResponse("Customer Claim Response");
        claim.setCustomerId(1);
        claim.setDateOfAccident("2020-03-01");
        claim.setId(1);
        claim.setPolicyApplicationId(1);
        claim.setPolicyId(1);
        claim.setSurveyorId(1);
        when(claimDao.findByCustomerIdAndPolicyId(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(claim);

        // Act
        Claim actualByCustomerIdAndPolicyId = claimServiceImpl.getByCustomerIdAndPolicyId(1, 1);

        // Assert
        verify(claimDao).findByCustomerIdAndPolicyId(eq(1), eq(1));
        assertSame(claim, actualByCustomerIdAndPolicyId);
    }
}
