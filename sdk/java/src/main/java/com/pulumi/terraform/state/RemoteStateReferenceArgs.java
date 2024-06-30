package com.pulumi.terraform.state;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.resources.ResourceArgs;

/**
 * The base type for arguments for constructing a RemoteStateReference resource.
 */
public abstract class RemoteStateReferenceArgs extends ResourceArgs {

    /**
     * A constant describing the name of the Terraform backend, used as the discriminant
     * for the union of backend configurations.
     */
    @Import(name = "backendType", required = true)
    private final Output<String> backendType;

    protected RemoteStateReferenceArgs(Output<String> backendType) {

        this.backendType = backendType;
    }
}
