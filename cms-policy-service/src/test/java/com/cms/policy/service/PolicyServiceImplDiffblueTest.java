package com.cms.policy.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cms.policy.dao.PolicyDao;
import com.cms.policy.entity.Policy;

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

@ContextConfiguration(classes = {PolicyServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PolicyServiceImplDiffblueTest {
    @MockBean
    private PolicyDao policyDao;

    @Autowired
    private PolicyServiceImpl policyServiceImpl;

    /**
     * Method under test: {@link PolicyServiceImpl#addPolicy(Policy)}
     */
    @Test
    void testAddPolicy() {
        // Arrange
        Policy policy = new Policy();
        policy.setCoverageDetailsList(new ArrayList<>());
        policy.setDescription("The characteristics of someone or something");
        policy.setId(1);
        policy.setName("Name");
        policy.setPlan("Plan");
        policy.setPolicyId("42");
        policy.setPremiumAmount(new BigDecimal("2.3"));
        policy.setStatus("Status");
        when(policyDao.save(Mockito.<Policy>any())).thenReturn(policy);

        Policy policy2 = new Policy();
        policy2.setCoverageDetailsList(new ArrayList<>());
        policy2.setDescription("The characteristics of someone or something");
        policy2.setId(1);
        policy2.setName("Name");
        policy2.setPlan("Plan");
        policy2.setPolicyId("42");
        policy2.setPremiumAmount(new BigDecimal("2.3"));
        policy2.setStatus("Status");

        // Act
        Policy actualAddPolicyResult = policyServiceImpl.addPolicy(policy2);

        // Assert
        verify(policyDao).save(isA(Policy.class));
        assertSame(policy, actualAddPolicyResult);
    }

    /**
     * Method under test: {@link PolicyServiceImpl#updatePolicy(Policy)}
     */
    @Test
    void testUpdatePolicy() {
        // Arrange
        Policy policy = new Policy();
        policy.setCoverageDetailsList(new ArrayList<>());
        policy.setDescription("The characteristics of someone or something");
        policy.setId(1);
        policy.setName("Name");
        policy.setPlan("Plan");
        policy.setPolicyId("42");
        policy.setPremiumAmount(new BigDecimal("2.3"));
        policy.setStatus("Status");
        when(policyDao.save(Mockito.<Policy>any())).thenReturn(policy);

        Policy policy2 = new Policy();
        policy2.setCoverageDetailsList(new ArrayList<>());
        policy2.setDescription("The characteristics of someone or something");
        policy2.setId(1);
        policy2.setName("Name");
        policy2.setPlan("Plan");
        policy2.setPolicyId("42");
        policy2.setPremiumAmount(new BigDecimal("2.3"));
        policy2.setStatus("Status");

        // Act
        Policy actualUpdatePolicyResult = policyServiceImpl.updatePolicy(policy2);

        // Assert
        verify(policyDao).save(isA(Policy.class));
        assertSame(policy, actualUpdatePolicyResult);
    }

    /**
     * Method under test: {@link PolicyServiceImpl#getById(int)}
     */
    @Test
    void testGetById() {
        // Arrange
        Policy policy = new Policy();
        policy.setCoverageDetailsList(new ArrayList<>());
        policy.setDescription("The characteristics of someone or something");
        policy.setId(1);
        policy.setName("Name");
        policy.setPlan("Plan");
        policy.setPolicyId("42");
        policy.setPremiumAmount(new BigDecimal("2.3"));
        policy.setStatus("Status");
        Optional<Policy> ofResult = Optional.of(policy);
        when(policyDao.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        Policy actualById = policyServiceImpl.getById(1);

        // Assert
        verify(policyDao).findById(eq(1));
        assertSame(policy, actualById);
    }

    /**
     * Method under test: {@link PolicyServiceImpl#getById(int)}
     */
    @Test
    void testGetById2() {
        // Arrange
        Optional<Policy> emptyResult = Optional.empty();
        when(policyDao.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        // Act
        Policy actualById = policyServiceImpl.getById(1);

        // Assert
        verify(policyDao).findById(eq(1));
        assertNull(actualById);
    }

    /**
     * Method under test: {@link PolicyServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        // Arrange
        ArrayList<Policy> policyList = new ArrayList<>();
        when(policyDao.findAll()).thenReturn(policyList);

        // Act
        List<Policy> actualAll = policyServiceImpl.getAll();

        // Assert
        verify(policyDao).findAll();
        assertTrue(actualAll.isEmpty());
        assertSame(policyList, actualAll);
    }

    /**
     * Method under test: {@link PolicyServiceImpl#getAllByStatus(String)}
     */
    @Test
    void testGetAllByStatus() {
        // Arrange
        ArrayList<Policy> policyList = new ArrayList<>();
        when(policyDao.findByStatus(Mockito.<String>any())).thenReturn(policyList);

        // Act
        List<Policy> actualAllByStatus = policyServiceImpl.getAllByStatus("Status");

        // Assert
        verify(policyDao).findByStatus(eq("Status"));
        assertTrue(actualAllByStatus.isEmpty());
        assertSame(policyList, actualAllByStatus);
    }
}
